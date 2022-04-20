package com.example.restaurantinformationsystem.dao;

import com.example.restaurantinformationsystem.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<DishEntity, Long> {
    DishEntity getById(long id);
}
