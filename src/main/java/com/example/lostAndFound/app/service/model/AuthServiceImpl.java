package com.example.lostAndFound.app.service.model;

import com.example.lostAndFound.api.dto.request.LoginRequest;
import com.example.lostAndFound.api.dto.request.RegisterRequest;
import com.example.lostAndFound.api.dto.response.AuthResponse;
import com.example.lostAndFound.app.config.security.JwtTokenProvider;
import com.example.lostAndFound.app.repository.UserRepository;
import com.example.lostAndFound.app.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.lostAndFound.app.repository.entity.UserEntity;
import com.example.lostAndFound.app.repository.entity.Role;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already used!");
        }
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already used!");
        }

        UserEntity user = UserEntity.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .address(request.getAddress())
                .phone(request.getPhone())
                .createdAt(LocalDateTime.now())
                .role(Role.CLIENT)
                .build();

        userRepository.save(user);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword(),
                user.getAuthorities()
        );

        String jwtToken = jwtTokenProvider.generateToken(authentication);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );


        String jwtToken = jwtTokenProvider.generateToken(authentication);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
