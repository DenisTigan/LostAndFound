package com.example.lostAndFound.api.dto.request;

import com.example.lostAndFound.app.repository.entity.ItemCategory;
import com.example.lostAndFound.app.repository.entity.ItemStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemUpdateRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private ItemStatus status;
    @NotNull
    private ItemCategory category;
    @NotBlank
    private String location;
}