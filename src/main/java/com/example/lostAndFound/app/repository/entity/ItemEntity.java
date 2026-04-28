package com.example.lostAndFound.app.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "ITEM_ENTITY")
@Entity
@Getter
@Setter
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    @Column(name = "ITEM_TITLE", nullable = false)
    private String title;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ITEM_STATUS", nullable = false)
    private ItemStatus status;

    @NotBlank
    @Column(name = "ITEM_DESCRIPTION", nullable = false)
    private String description;

    @NotNull
    @Column(name = "ITEM_PUBLISH_DATE", nullable = false)
    private LocalDate publishDate;

    @NotNull
    @Column(name = "ITEM_EXPIRATION_DATE", nullable = false)
    private LocalDate expirationDate;

    @NotNull
    @Column(name = "ITEM_UPDATED_AD", nullable = false)
    private LocalDate updatedAt;

    @NotBlank
    @Column(name = "ITEM_LOCATION", nullable = false)
    private String location;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ITEM_CATEGORY", nullable = false)
    private ItemCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lost_and_found_user", nullable = false)
    private UserEntity user;

    @PrePersist
    private void onPrePersist(){
        this.updatedAt = LocalDate.now();
    }

}
