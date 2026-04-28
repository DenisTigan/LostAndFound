package com.example.lostAndFound.app.service;

import com.example.lostAndFound.api.dto.request.LoginRequest;
import com.example.lostAndFound.api.dto.request.RegisterRequest;
import com.example.lostAndFound.api.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
