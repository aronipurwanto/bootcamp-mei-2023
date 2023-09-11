package com.bootcamp.securitydemo.controller;

import com.bootcamp.securitydemo.config.IAuthenticationFacade;
import com.bootcamp.securitydemo.config.JwtUtils;
import com.bootcamp.securitydemo.dto.AuthRequest;
import com.bootcamp.securitydemo.dto.Response;
import com.bootcamp.securitydemo.dto.UserResponse;
import com.bootcamp.securitydemo.entity.UserEntity;
import com.bootcamp.securitydemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserService userDetailsService;
    private final JwtUtils jwtUtils;
    private final IAuthenticationFacade authenticationFacade;

    @PostMapping("/authenticate")
    public ResponseEntity<Response> authenticate(@RequestBody AuthRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        final UserDetails user  = userDetailsService.loadUserByUsername(request.getEmail());
        if(user != null){
            String token =  jwtUtils.generateToken(user);
            return ResponseEntity.ok().body(
                    new Response(200,"SUCCESS", token)
            );
        }else {
            return ResponseEntity.status(400)
                    .body(
                            new Response(400,"Something has error occurred",null)
                    );
        }
    }

    @GetMapping("/username")
    public ResponseEntity<Response> getUsername(){
        Authentication authentication = authenticationFacade.getAuthentication();
        String username = authentication.getName();
        Optional<UserEntity> userEntity = userDetailsService.getByEmail(username);

        if(userEntity.isPresent()){
            UserResponse result = new UserResponse(userEntity.get());
            return ResponseEntity.ok().body(
                    new Response(200,"SUCCESS", result)
            );
        }else {
            return ResponseEntity.status(500)
                    .body(
                            new Response(500,"FAILED", "User not found")
                    );
        }
    }
}
