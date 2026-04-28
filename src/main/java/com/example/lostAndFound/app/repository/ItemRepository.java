package com.example.lostAndFound.app.repository;

import com.example.lostAndFound.app.repository.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
