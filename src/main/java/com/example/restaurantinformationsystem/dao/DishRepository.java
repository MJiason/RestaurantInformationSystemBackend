package com.example.restaurantinformationsystem.dao;

import com.example.restaurantinformationsystem.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface DishRepository extends JpaRepository<DishEntity, Long> {
    DishEntity getById(long id);
    Set<DishEntity> findAllByCategory_Name(String categoryName);
}
