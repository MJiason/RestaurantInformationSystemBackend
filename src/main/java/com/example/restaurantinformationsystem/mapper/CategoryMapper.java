package com.example.restaurantinformationsystem.mapper;

import com.example.restaurantinformationsystem.dto.CategoryDto;
import com.example.restaurantinformationsystem.entity.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CategoryMapper {
    private final ModelMapper modelMapper;


    public Set<CategoryDto> mapToCategoryDto(Set<Category> categoriesSet) {
        Set<CategoryDto> categories = new HashSet<>();
        for (Category category : categoriesSet) {
            categories.add(modelMapper.map(category, CategoryDto.class));
        }
        return categories;
    }
}
