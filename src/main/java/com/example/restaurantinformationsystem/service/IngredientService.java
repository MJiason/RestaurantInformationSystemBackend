package com.example.restaurantinformationsystem.service;

import com.example.restaurantinformationsystem.dao.IngredientRepository;
import com.example.restaurantinformationsystem.dto.IngredientDto;
import com.example.restaurantinformationsystem.entity.IngredientEntity;
import com.example.restaurantinformationsystem.mapper.IngredientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    public Set<IngredientDto> getAllIngredients() {
        Set<IngredientEntity> ingredientEntities = ingredientRepository.getAllByIdIsNotNull();
        if (ingredientEntities.isEmpty()) {
            throw new NullPointerException("No ingredients found");
        }
        return ingredientMapper.mapToIngredientDto(ingredientEntities);
    }
}
