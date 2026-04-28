package com.example.lostAndFound.app.utils;

import com.example.lostAndFound.api.dto.request.UserRequestDto;
import com.example.lostAndFound.api.dto.response.UserResponseDto;
import com.example.lostAndFound.app.repository.entity.UserEntity;
import com.example.lostAndFound.app.service.model.request.UserRequest;
import com.example.lostAndFound.app.service.model.response.UserResponse;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@UtilityClass
public class UserConverter {

    public UserRequest toUserRequest(UserRequestDto dto) {
        return UserRequest.builder()
                .email(dto.getEmail())
                .username(dto.getUsername())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .build();
    }

    public UserResponse toUserResponse(UserEntity entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .username(entity.getUsername())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .address(entity.getAddress())
                .phone(entity.getPhone())
                .createdAt(entity.getCreatedAt())
                .role(entity.getRole() != null ? entity.getRole().name() : null)
                .build();
    }

    public UserResponseDto toUserResponseDto(UserResponse response) {
        return UserResponseDto.builder()
                .id(response.getId())
                .email(response.getEmail())
                .username(response.getUsername())
                .firstName(response.getFirstName())
                .lastName(response.getLastName())
                .address(response.getAddress())
                .phone(response.getPhone())
                .createdAt(response.getCreatedAt())
                .role(response.getRole())
                .build();
    }

    public UserResponseDto toDto(UserResponse response) {

        return UserResponseDto.builder()
                .id(response.getId())
                .email(response.getEmail())
                .firstName(response.getFirstName())
                .lastName(response.getLastName())
                .phoneNumber(response.getPhoneNumber())
                .address(response.getAddress())
                .role(response.getRole())
                .createdAt(response.getCreatedAt())
                .build();
    }
}