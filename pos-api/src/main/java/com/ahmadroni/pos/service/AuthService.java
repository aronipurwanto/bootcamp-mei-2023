package com.ahmadroni.pos.service;

import com.ahmadroni.pos.model.AuthRequest;
import com.ahmadroni.pos.model.AuthResponse;
import com.ahmadroni.pos.model.ProfileResponse;
import com.ahmadroni.pos.model.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

public interface AuthService {
    Optional<AuthResponse> authenticate(AuthRequest request);
    Optional<AuthResponse> register(RegisterRequest request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
    Optional<ProfileResponse> profile(HttpServletRequest request, HttpServletResponse response);
}
