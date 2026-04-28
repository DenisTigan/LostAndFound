package com.example.lostAndFound.app.rest;

import com.example.lostAndFound.api.UserController;
import com.example.lostAndFound.api.dto.response.UserResponseDto;
import com.example.lostAndFound.app.service.UserService;
import com.example.lostAndFound.app.service.model.response.UserResponse;
import com.example.lostAndFound.utils.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserControllerImpl implements UserController {

    private final UserConverter userConverter;
    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserConverter userConverter, UserService userService) {
        this.userConverter = userConverter;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserResponseDto> getUserById(Long id) {

        UserResponse internalResponse = userService.getUserById(id);

        return ResponseEntity.ok(userConverter.toDto(internalResponse));
    }
}