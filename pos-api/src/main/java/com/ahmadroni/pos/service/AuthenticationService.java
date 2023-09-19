package com.ahmadroni.pos.service;

import com.ahmadroni.pos.model.AuthenticationRequest;
import com.ahmadroni.pos.model.AuthenticationResponse;
import com.ahmadroni.pos.model.ProfileResponse;
import com.ahmadroni.pos.model.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

public interface AuthenticationService {
    Optional<AuthenticationResponse> authenticate(AuthenticationRequest request);
    Optional<AuthenticationResponse> register(RegisterRequest request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
    Optional<ProfileResponse> profile(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
