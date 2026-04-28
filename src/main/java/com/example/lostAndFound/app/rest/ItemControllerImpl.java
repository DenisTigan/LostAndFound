package com.example.lostAndFound.app.rest;

import com.example.lostAndFound.api.ItemController;
import com.example.lostAndFound.api.dto.request.AddItemRequestDto;
import com.example.lostAndFound.api.dto.response.ItemResponseDto;
import com.example.lostAndFound.app.repository.entity.ItemEntity;
import com.example.lostAndFound.app.service.ItemServiceImpl;
import com.example.lostAndFound.app.service.model.response.ItemResponse;
import com.example.lostAndFound.app.utils.ItemConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemControllerImpl implements ItemController {

    private final ItemServiceImpl itemService;

    @Autowired
    public ItemControllerImpl(ItemServiceImpl userService){
        this.itemService = userService;
    }

    @Override
    public ResponseEntity<ItemResponseDto> addIdem(AddItemRequestDto newItem) {

        ItemResponse response = itemService.addItem(ItemConverter.convertRequestDtoToItemRequest(newItem));

        ItemResponseDto itemResponseDto = ItemConverter.covertItemResponseToItemResponseDto(response);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(itemResponseDto);

    }

    @Override
    public ResponseEntity<List<ItemResponseDto>> getAllItems() {

        List<ItemResponse> itemsList = itemService.getAllItems();

        List<ItemResponseDto> itemResponseDtoList = itemsList.stream()
                .map((ItemConverter::covertItemResponseToItemResponseDto))
                .toList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(itemResponseDtoList);
    }

}
