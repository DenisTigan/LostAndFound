package com.example.lostAndFound.app.service;

import com.example.lostAndFound.app.service.model.request.ItemRequest;
import com.example.lostAndFound.app.service.model.request.ItemUpdateRequest;
import com.example.lostAndFound.app.service.model.response.ItemResponse;

import java.util.List;

public interface ItemService {
    ItemResponse updateItem(Long id, ItemUpdateRequest itemUpdateRequest);

    boolean deleteItemById(Long id);

    ItemResponse findById(Long id);

    ItemResponse addItem(ItemRequest newRequest);

    List<ItemResponse> getAllItems();

}