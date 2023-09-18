package com.ahmadroni.pos.service.impl;

import com.ahmadroni.pos.config.JwtUtil;
import com.ahmadroni.pos.entity.UserEntity;
import com.ahmadroni.pos.model.AuthenticationRequest;
import com.ahmadroni.pos.model.AuthenticationResponse;
import com.ahmadroni.pos.model.RegisterRequest;
import com.ahmadroni.pos.repository.UserRepo;
import com.ahmadroni.pos.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepo userRepo;
    private final JwtUtil jwtService;
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
            return Optional.empty();
        }

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        var result =  new AuthenticationResponse(jwtToken, refreshToken);

        return Optional.of(result);
    }
}
