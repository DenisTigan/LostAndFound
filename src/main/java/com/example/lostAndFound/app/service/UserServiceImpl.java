package com.example.lostAndFound.app.service;

import com.example.lostAndFound.app.repository.UserRepository;
import com.example.lostAndFound.app.repository.entity.UserEntity;
import com.example.lostAndFound.app.service.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse getUserById(Long id) {

        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: User with ID " + id + " not found."));


        return UserResponse.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .phoneNumber(entity.getPhone())
                .address(entity.getAddress())
                .role(entity.getRole().toString())
                .build();
    }
}