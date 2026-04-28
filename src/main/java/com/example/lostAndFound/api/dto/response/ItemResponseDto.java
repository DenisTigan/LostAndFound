package com.example.lostAndFound.api.dto.response;

import com.example.lostAndFound.app.repository.entity.ItemCategory;
import com.example.lostAndFound.app.repository.entity.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemResponseDto {
    private Long id;
    private String title;
    private ItemStatus status;
    private String description;
    private LocalDate publishDate;
    private LocalDate expirationDate;
    private String location;
    private ItemCategory category;
}
