package com.example.lostAndFound.app.service;

import com.example.lostAndFound.app.service.model.request.UserRequest;
import com.example.lostAndFound.app.service.model.response.UserResponse;

public interface UserService {
    UserResponse updateUserById(Long id, UserRequest request);
    UserResponse getUserById(Long id);
}
