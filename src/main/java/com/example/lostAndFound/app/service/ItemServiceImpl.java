package com.example.lostAndFound.app.service;

import com.example.lostAndFound.app.repository.ItemRepository;
import com.example.lostAndFound.app.repository.entity.ItemEntity;
import com.example.lostAndFound.app.service.model.request.ItemRequest;
import com.example.lostAndFound.app.service.model.request.ItemUpdateRequest;
import com.example.lostAndFound.app.service.model.response.ItemResponse;
import com.example.lostAndFound.app.utils.ItemConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;


    @Override
    public ItemResponse updateItem(Long id, ItemUpdateRequest updateRequest) {
        ItemEntity item = itemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item nu a fost gasit cu id: " + id));

        item.setTitle(updateRequest.getTitle());
        item.setDescription(updateRequest.getDescription());
        item.setStatus(updateRequest.getStatus());
        item.setCategory(updateRequest.getCategory());
        item.setLocation(updateRequest.getLocation());
        item.setUpdatedAt(LocalDate.now());

        itemRepository.save(item);
        return ItemConverter.convertItemEntityToItemResponse(item);
    }

    @Override
    public boolean deleteItemById(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ItemResponse findById(Long id) {
        ItemEntity item = itemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item nu a fost gasit cu id: " + id));

        return ItemConverter.convertItemEntityToItemResponse(item);
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