package com.example.lostAndFound.api;

import com.example.lostAndFound.api.dto.request.AddItemRequestDto;
import com.example.lostAndFound.api.dto.request.ItemUpdateRequestDto;
import com.example.lostAndFound.api.dto.response.ItemResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/items")
@Validated
public interface ItemController {

    @PostMapping("/create")
    ResponseEntity<ItemResponseDto> addIdem(@Valid @RequestBody AddItemRequestDto requestDto);

    @PutMapping("/{id}")
    ItemResponseDto updateItem(@PathVariable @NotNull Long id, @Valid @RequestBody ItemUpdateRequestDto dto);

    @GetMapping("/getAllItems")
    ResponseEntity<List<ItemResponseDto>> getAllItems();

    @DeleteMapping("/{id}")
    void deleteItem(@NotNull @PathVariable Long id);

    @GetMapping("/{id}")
    ItemResponseDto getItemById(@PathVariable Long id);
}
