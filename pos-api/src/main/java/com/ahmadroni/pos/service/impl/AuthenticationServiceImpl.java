package com.ahmadroni.pos.service.impl;

import com.ahmadroni.pos.config.CommonConstant;
import com.ahmadroni.pos.config.JwtUtil;
import com.ahmadroni.pos.entity.RoleEntity;
import com.ahmadroni.pos.entity.TokenEntity;
import com.ahmadroni.pos.entity.UserEntity;
import com.ahmadroni.pos.model.AuthenticationRequest;
import com.ahmadroni.pos.model.AuthenticationResponse;
import com.ahmadroni.pos.model.ProfileResponse;
import com.ahmadroni.pos.model.RegisterRequest;
import com.ahmadroni.pos.repository.RoleRepo;
import com.ahmadroni.pos.repository.TokenRepo;
import com.ahmadroni.pos.repository.UserRepo;
import com.ahmadroni.pos.service.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final TokenRepo tokenRepo;
    private final JwtUtil jwtService;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public Optional<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserEntity user = userRepo.findByEmail(request.getEmail()).orElse(null);
        if(user == null){
            log.info("User not found");
            return Optional.empty();
        }

        // return dengan panggil method getResponse
        return getResponse(user, false);
    }

    @Override
    public Optional<AuthenticationResponse> register(RegisterRequest request) {
        if(request == null) {
            return Optional.empty();
        }

        //  check email, apakah sudah digunakan apa belum
        if(userRepo.findByEmail(request.getEmail()).isPresent()){
            log.info("Email already in used");
            return Optional.empty();
        }

        UserEntity user = new UserEntity();
        // di copy semua data dari request ke object user
        BeanUtils.copyProperties(request, user);

        // set password diganti dengan enkripsi
        user.setPassword(encoder.encode(request.getPassword()));

        // get role
        RoleEntity role = getRole(request.getRole());
        if(role != null){
            // set value ke roles
            user.setRoles(List.of(role));
        }

        try{
            userRepo.save(user);
            log.info("Create user success");

            // jika berhasil save, maka kembalikan nilai dengan panggil method getResponse
            return getResponse(user, true);
        }catch (Exception e){
            log.error("Create user failed, error: {}", e.getMessage());
            // jika gagal save, mama kembalikan data kosong
            return Optional.empty();
        }
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;

        if(authHeader == null || !authHeader.startsWith(CommonConstant.BEARER_VALUE)){
            return;
        }

        // di ambil string dari index ke 7
        refreshToken = authHeader.substring(7);
        // extract email dari token lewat method jwtService.extractUsername
        userEmail = jwtService.extractUsername(refreshToken);

        // jika userEmail nya tidak null, jika null maka lewat
        if(userEmail != null){
            // check use entity lewat userRepo.findByEmail
            // jika user tidak ditemukan, maka berikan pesan error
            UserEntity user = userRepo.findByEmail(userEmail).orElseThrow(() -> new UsernameNotFoundException("User not found"));

            // jika tokennya valid
            if(jwtService.isTokenValid(refreshToken, user)){
                // call method get response
                Optional<AuthenticationResponse> authResponse = this.getResponse(user, false);
                // set response
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

    @Override
    public Optional<ProfileResponse> profile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;

        if(authHeader == null || !authHeader.startsWith(CommonConstant.BEARER_VALUE)){
            return Optional.empty();
        }

        // di ambil string dari index ke 7
        refreshToken = authHeader.substring(7);
        // extract email dari token lewat method jwtService.extractUsername
        userEmail = jwtService.extractUsername(refreshToken);

        // jika userEmail nya null maka return empty
        if(userEmail == null) {
            return Optional.empty();
        }

        // jika user tidak ditemukan, maka berikan pesan error
        UserEntity user = userRepo.findByEmail(userEmail).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        ProfileResponse result = new ProfileResponse();
        BeanUtils.copyProperties(user, result);
        // get roles dari user ..
        List<String> roles = user.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList());
        result.setRoles(roles);
        // return
        return Optional.of(result);
    }

    private Optional<AuthenticationResponse> getResponse(UserEntity user, boolean isRegister){
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        // save token
        this.saveUserToken(user.getId(), jwtToken);

        // when not register
        if(!isRegister)
            this.revokeAllUserTokens(user);

        // generate response
        var result =  new AuthenticationResponse(jwtToken, refreshToken);

        return Optional.of(result);
    }

    private RoleEntity getRole(String roleName){
        RoleEntity role = roleRepo.findByName(roleName).orElse(null);
        if(role != null){
           return role;
        }

        role = roleRepo.findByName(CommonConstant.DEFAULT_ROLE).orElse(null);
        return role;
    }

    private void saveUserToken(Long userId, String jwtToken) {
        var token = new TokenEntity();
        token.setUserId(userId);
        token.setToken(jwtToken);
        token.setTokenType(CommonConstant.BEARER_TYPE);
        token.setExpired(false);
        token.setRevoked(false);
        try {
            tokenRepo.save(token);
            log.info("Save token success");
        }catch (Exception e){
            log.error("Save token failed, error: {}", e.getMessage());
        }
    }

    private void revokeAllUserTokens(UserEntity user) {
        var validUserTokens = tokenRepo.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;

        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepo.saveAll(validUserTokens);
    }
}
