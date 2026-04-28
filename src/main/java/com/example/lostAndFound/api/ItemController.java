package com.example.lostAndFound.api;

import com.example.lostAndFound.api.dto.request.AddItemRequestDto;
import com.example.lostAndFound.api.dto.response.ItemResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/items")
@Validated
public interface ItemController {

    @PostMapping("/create")
    ResponseEntity<ItemResponseDto> addIdem(@Valid @RequestBody AddItemRequestDto requestDto);

    @GetMapping("/getAllItems")
    ResponseEntity<List<ItemResponseDto>> getAllItems();

}
