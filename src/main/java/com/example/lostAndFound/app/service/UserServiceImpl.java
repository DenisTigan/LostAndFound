package com.example.lostAndFound.app.service;

import com.example.lostAndFound.app.repository.entity.UserEntity;
import com.example.lostAndFound.app.repository.entity.UserRepository;
import com.example.lostAndFound.app.service.model.request.UserRequest;
import com.example.lostAndFound.app.service.model.response.UserResponse;
import com.example.lostAndFound.app.utils.UserConverter;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse updateUserById(Long id, UserRequest request) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));

        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());

        UserEntity saved = userRepository.save(user);
        return UserConverter.toUserResponse(saved);
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
                .createdAt(entity.getCreatedAt())
                .build();
    }
}