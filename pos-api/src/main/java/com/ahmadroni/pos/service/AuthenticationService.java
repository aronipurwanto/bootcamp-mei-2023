package com.ahmadroni.pos.service;

import com.ahmadroni.pos.model.AuthenticationRequest;
import com.ahmadroni.pos.model.AuthenticationResponse;
import com.ahmadroni.pos.model.RegisterRequest;

import java.util.Optional;

public interface AuthenticationService {
    Optional<AuthenticationResponse> authenticate(AuthenticationRequest request);
}
