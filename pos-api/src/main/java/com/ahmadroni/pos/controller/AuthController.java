package com.ahmadroni.pos.controller;

import com.ahmadroni.pos.model.*;
import com.ahmadroni.pos.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseModel> authenticate(@RequestBody AuthRequest request){
        Optional<AuthResponse> result = authService.authenticate(request);
        if(result.isPresent()) {
            return ResponseEntity.ok()
                    .body(new ResponseModel(200, "SUCCESS", result));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseModel(400,"FAILED","User Not found"));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseModel> register(@RequestBody RegisterRequest request) {
        Optional<AuthResponse> result = authService.register(request);

        if(result.isPresent()) {
            return ResponseEntity.ok()
                    .body(new ResponseModel(200, "SUCCESS", result));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseModel(400,"FAILED","Register is failed"));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        authService.refreshToken(request, response);
    }

    @GetMapping("/profile")
    public ResponseEntity<ResponseModel> getProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Optional<ProfileResponse> result = authService.profile(request, response);
        if(result.isPresent()) {
            return ResponseEntity.ok()
                    .body(new ResponseModel(200, "SUCCESS", result));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseModel(500,"FAILED","User not found"));
    }
}
