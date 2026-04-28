package com.example.lostAndFound.app.service.model.request;

import com.example.lostAndFound.app.repository.entity.ItemCategory;
import com.example.lostAndFound.app.repository.entity.ItemStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemUpdateRequest {
    private String title;
    private String description;
    private ItemStatus status;
    private ItemCategory category;
    private String location;
}
