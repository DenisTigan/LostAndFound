package com.example.lostAndFound.app.repository.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="lost_and_found_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LST_USER_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "LST_USER_FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LST_USER_LAST_NAME", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(name = "LST_USER_PHONE")
    private String phone;

    @Column(name = "LST_USER_CREATED_AT", updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


}
