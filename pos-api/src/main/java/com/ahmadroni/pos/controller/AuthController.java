package com.ahmadroni.pos.controller;

import com.ahmadroni.pos.config.JwtUtil;
import com.ahmadroni.pos.model.AuthenticationRequest;
import com.ahmadroni.pos.model.AuthenticationResponse;
import com.ahmadroni.pos.model.ResponseModel;
import com.ahmadroni.pos.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseModel> authenticate(@RequestBody AuthenticationRequest request){
        Optional<AuthenticationResponse> result = authService.authenticate(request);
        if(result.isPresent()) {
            return ResponseEntity.ok().body(
                    new ResponseModel(200, "SUCCESS", result)
            );
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        new ResponseModel(400,"FAILED","User Not found")
                );
    }
}
