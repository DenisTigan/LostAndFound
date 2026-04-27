package com.example.lostAndFound.app.rest;

import com.example.lostAndFound.api.UserController;
import com.example.lostAndFound.api.dto.response.UserResponseDto;
import com.example.lostAndFound.app.service.UserService;
import com.example.lostAndFound.app.service.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController // This badge is the only thing needed here to tell Spring this is a web worker.
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserResponseDto> getUserById(Long id) {
        // 1. Ask the Service for the internal model
        UserResponse internalResponse = userService.getUserById(id);

        // 2. Translate to DTO
        UserResponseDto publicDto = new UserResponseDto(
                internalResponse.getId(),
                internalResponse.getEmail(),
                internalResponse.getFirstName(),
                internalResponse.getLastName(),
                internalResponse.getPhoneNumber()
        );

        // 3. Return to the internet
        return ResponseEntity.ok(publicDto);
    }
}