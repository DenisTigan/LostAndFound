package com.example.lostAndFound.app.service;

import com.example.lostAndFound.api.dto.response.ItemResponseDto;
import com.example.lostAndFound.app.repository.entity.ItemEntity;
import com.example.lostAndFound.app.service.model.request.ItemRequest;
import com.example.lostAndFound.app.service.model.response.ItemResponse;

import java.util.List;

public interface ItemService {

    ItemResponse addItem(ItemRequest newRequest);

    List<ItemResponse> getAllItems();

}
