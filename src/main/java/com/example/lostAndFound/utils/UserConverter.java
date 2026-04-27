package com.example.lostAndFound.utils;

import com.example.lostAndFound.api.dto.response.UserResponseDto;
import com.example.lostAndFound.app.service.model.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {


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