package com.example.restaurantinformationsystem.dao;

import com.example.restaurantinformationsystem.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
    Set<IngredientEntity> getAllByIdIsNotNull();
}
