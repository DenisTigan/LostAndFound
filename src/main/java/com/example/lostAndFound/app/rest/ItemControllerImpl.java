package com.example.lostAndFound.app.rest;

import com.example.lostAndFound.api.ItemController;
import com.example.lostAndFound.api.dto.request.AddItemRequestDto;
import com.example.lostAndFound.api.dto.request.ItemUpdateRequestDto;
import com.example.lostAndFound.api.dto.response.ItemResponseDto;
import com.example.lostAndFound.api.exception.ItemNotFoundException;
import com.example.lostAndFound.app.service.ItemService;
import com.example.lostAndFound.app.service.model.request.ItemUpdateRequest;
import com.example.lostAndFound.app.service.model.response.ItemResponse;
import com.example.lostAndFound.app.utils.ItemConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemControllerImpl implements ItemController {

    private final ItemService itemService;

    @Override
    public ItemResponseDto updateItem(Long id, ItemUpdateRequestDto dto) {
        ItemUpdateRequest itemUpdateRequest = ItemConverter.convertToItemUpdateRequest(dto);
        ItemResponse itemResponse = itemService.updateItem(id, itemUpdateRequest);
        return ItemConverter.convertToItemResponseDto(itemResponse);
    }

    @Override
    public void deleteItem(Long id) {
        boolean deleted = itemService.deleteItemById(id);
        if (!deleted) {
            throw new ItemNotFoundException("Item nu a fost găsit cu id: " + id);
        }
    }

    @Override
    @GetMapping("/{id}")
    public ItemResponseDto getItemById(@PathVariable Long id) {
        ItemResponse item = itemService.findById(id);
        return ItemConverter.convertToItemResponseDto(item);
    }


    @Override
    public ResponseEntity<ItemResponseDto> addIdem(AddItemRequestDto newItem) {

        ItemResponse response = itemService.addItem(ItemConverter.convertRequestDtoToItemRequest(newItem));

        ItemResponseDto itemResponseDto = ItemConverter.convertToItemResponseDto(response);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(itemResponseDto);

    }

    @Override
    public ResponseEntity<List<ItemResponseDto>> getAllItems() {

        List<ItemResponse> itemsList = itemService.getAllItems();

        List<ItemResponseDto> itemResponseDtoList = itemsList.stream()
                .map((ItemConverter::convertToItemResponseDto))
                .toList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(itemResponseDtoList);
    }
}