package com.example.lostAndFound.api;

import com.example.lostAndFound.api.dto.request.UserRequestDto;
import com.example.lostAndFound.api.dto.response.UserResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequestMapping("/users")
public interface UserController {
    @GetMapping("/{id}")
     ResponseEntity<UserResponseDto> getUserById(@PathVariable @NotNull Long id);

    @PutMapping("/{id}")
    ResponseEntity<UserResponseDto> updateUserById(@NotNull @PathVariable Long id, @Valid @RequestBody UserRequestDto request);
}