package com.bootcamp.securitydemo.controller;

import com.bootcamp.securitydemo.config.JwtUtils;
import com.bootcamp.securitydemo.dto.AuthRequest;
import com.bootcamp.securitydemo.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;

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
}
