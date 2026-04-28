package com.example.lostAndFound.app.rest;

import com.example.lostAndFound.api.UserController;
import com.example.lostAndFound.api.dto.request.UserRequestDto;
import com.example.lostAndFound.api.dto.request.UserRequestDto;
import com.example.lostAndFound.api.dto.response.UserResponseDto;
import com.example.lostAndFound.app.service.UserService;
import com.example.lostAndFound.app.service.model.request.UserRequest;
import com.example.lostAndFound.app.service.model.request.UserRequest;
import com.example.lostAndFound.app.service.model.response.UserResponse;
import com.example.lostAndFound.app.utils.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<UserResponseDto> getUserById(Long id) {

        UserResponse internalResponse = userService.getUserById(id);

        return ResponseEntity.ok(UserConverter.toDto(internalResponse));
    }
    @Override
    public ResponseEntity<UserResponseDto> updateUserById(Long id, UserRequestDto requestDto) {
        UserRequest request = UserConverter.toUserRequest(requestDto);
        UserResponse response = userService.updateUserById(id, request);
        UserResponseDto responseDto = UserConverter.toUserResponseDto(response);
        return ResponseEntity.ok(responseDto);
    }
}