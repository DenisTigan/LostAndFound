package com.example.lostAndFound.app.service.model.request;

import com.example.lostAndFound.app.repository.entity.ItemCategory;
import com.example.lostAndFound.app.repository.entity.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemRequest {

    private String title;

    private String description;

    private String location;

    private ItemStatus status;

    private ItemCategory category;

}
