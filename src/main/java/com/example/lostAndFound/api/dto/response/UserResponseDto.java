package com.example.lostAndFound.api.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String phone;
    private LocalDateTime createdAt;
    private String role;
}