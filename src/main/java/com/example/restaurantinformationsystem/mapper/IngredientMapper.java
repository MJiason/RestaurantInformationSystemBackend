package com.example.restaurantinformationsystem.mapper;

import com.example.restaurantinformationsystem.dto.CategoryDto;
import com.example.restaurantinformationsystem.dto.IngredientDto;
import com.example.restaurantinformationsystem.entity.Category;
import com.example.restaurantinformationsystem.entity.IngredientEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class IngredientMapper {
    private final ModelMapper modelMapper;


    public Set<IngredientDto> mapToIngredientDto(Set<IngredientEntity> ingredientSet) {
        Set<IngredientDto> ingredients = new HashSet<>();
        for (IngredientEntity ingredient : ingredientSet) {
            ingredients.add(modelMapper.map(ingredient, IngredientDto.class));
        }
        return ingredients;
    }
}
