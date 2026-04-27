package com.example.lostAndFound.api;

import com.example.lostAndFound.api.dto.response.UserResponseDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping("/users")
public interface UserController {
    @GetMapping("/{id}")
     ResponseEntity<UserResponseDto> getUserById(@PathVariable @NotNull Long id);

}
