package com.example.lostAndFound.app.service;

import com.example.lostAndFound.api.dto.response.ItemResponseDto;
import com.example.lostAndFound.app.repository.ItemRepository;
import com.example.lostAndFound.app.repository.entity.ItemEntity;
import com.example.lostAndFound.app.service.model.request.ItemRequest;
import com.example.lostAndFound.app.service.model.response.ItemResponse;
import com.example.lostAndFound.app.utils.ItemConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemResponse addItem(ItemRequest newRequest) {

        ItemEntity newItem = ItemConverter.convertRequestToItemEntity(newRequest);

        return ItemConverter.convertItemEntityToItemResponse(itemRepository.save(newItem));

    }

    @Override
    public List<ItemResponse> getAllItems() {

        List<ItemEntity> itemEntities = itemRepository.findAll();

        return itemEntities.stream()
                .map(ItemConverter::convertItemEntityToItemResponse)
                .toList();

    }

}
