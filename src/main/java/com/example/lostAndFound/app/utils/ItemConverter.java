package com.example.lostAndFound.app.utils;

import com.example.lostAndFound.api.dto.request.AddItemRequestDto;
import com.example.lostAndFound.api.dto.request.ItemUpdateRequestDto;
import com.example.lostAndFound.api.dto.response.ItemResponseDto;
import com.example.lostAndFound.app.repository.entity.ItemEntity;
import com.example.lostAndFound.app.service.model.request.ItemRequest;
import com.example.lostAndFound.app.service.model.request.ItemUpdateRequest;
import com.example.lostAndFound.app.service.model.response.ItemResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class ItemConverter {

    public ItemEntity convertRequestToItemEntity(ItemRequest request){
        final ItemEntity newItem = new ItemEntity();

        newItem.setTitle(request.getTitle());
        newItem.setStatus(request.getStatus());
        newItem.setDescription(request.getDescription());
        newItem.setPublishDate(LocalDate.now());
        newItem.setExpirationDate(LocalDate.now().plusDays(30));
        newItem.setLocation(request.getLocation());
        newItem.setCategory(request.getCategory());

        return newItem;
    }


    public ItemResponse convertItemEntityToItemResponse(ItemEntity itemEntity){
        return ItemResponse.builder()
                .id(itemEntity.getId())
                .title(itemEntity.getTitle())
                .status(itemEntity.getStatus())
                .description(itemEntity.getDescription())
                .publishDate(itemEntity.getPublishDate())
                .expirationDate(itemEntity.getExpirationDate())
                .location(itemEntity.getLocation())
                .category(itemEntity.getCategory()).build();
    }

    public ItemResponseDto convertToItemResponseDto(ItemResponse item) {
        return ItemResponseDto.builder()
                .id(item.getId())
                .title(item.getTitle())
                .status(item.getStatus())
                .description(item.getDescription())
                .expirationDate(item.getExpirationDate())
                .location(item.getLocation())
                .publishDate(item.getPublishDate())
                .category(item.getCategory())
                .build();
    }

    public ItemUpdateRequest convertToItemUpdateRequest(ItemUpdateRequestDto itemUpdateRequestDto) {
        return ItemUpdateRequest.builder()
                .status(itemUpdateRequestDto.getStatus())
                .title(itemUpdateRequestDto.getTitle())
                .description(itemUpdateRequestDto.getDescription())
                .category(itemUpdateRequestDto.getCategory())
                .location(itemUpdateRequestDto.getLocation())
                .build();
    }

    public ItemRequest convertRequestDtoToItemRequest(AddItemRequestDto newRequest){
        ItemRequest newItem = new ItemRequest();

        newItem.setTitle(newRequest.getTitle());
        newItem.setStatus(newRequest.getStatus());
        newItem.setDescription(newRequest.getDescription());
        newItem.setLocation(newRequest.getLocation());
        newItem.setCategory(newRequest.getCategory());

        return newItem;

    }

}
