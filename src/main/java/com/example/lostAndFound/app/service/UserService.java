package com.example.lostAndFound.app.service;

import com.example.lostAndFound.app.service.model.response.UserResponse;

public interface UserService {
    UserResponse getUserById(Long id);
}
