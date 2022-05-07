package com.example.restaurantinformationsystem.mapper;

import com.example.restaurantinformationsystem.dto.DishDto;
import com.example.restaurantinformationsystem.dto.DishExtendedDto;
import com.example.restaurantinformationsystem.dto.IngredientDto;
import com.example.restaurantinformationsystem.entity.DishEntity;
import com.example.restaurantinformationsystem.entity.IngredientEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DishMapper {
    private final ModelMapper modelMapper;

    public DishDto mapToDishDto(DishEntity dish) {
        DishDto dishDto = modelMapper.map(dish, DishDto.class);
        dishDto.setIngredients(dish.getIngredients());
        dishDto.setCategory(dish.getCategory().getName());
        return dishDto;
    }

    public DishExtendedDto mapToDishExtendedDto(DishEntity dish) {
        DishExtendedDto dishExtendedDto = modelMapper.map(dish, DishExtendedDto.class);
         //dishExtendedDto.setCategory(dish.getCategory().getName());
        Set<IngredientDto> ingredientDtoSet = new HashSet<>();
        for (IngredientEntity ingredient : dish.getIngredients()) {
            ingredientDtoSet.add(modelMapper.map(ingredient, IngredientDto.class));
        }
        dishExtendedDto.setIngredients(ingredientDtoSet);
        return dishExtendedDto;
    }

    public DishEntity mapToDishEntity(DishExtendedDto dish) {
        DishEntity dishEntity = modelMapper.map(dish, DishEntity.class);
        Set<IngredientEntity> ingredientEntitySet = new HashSet<>();
        for (IngredientDto ingredient : dish.getIngredients()) {
            ingredientEntitySet.add(modelMapper.map(ingredient, IngredientEntity.class));
        }
        dishEntity.setIngredients(ingredientEntitySet);
        return dishEntity;
    }
}
