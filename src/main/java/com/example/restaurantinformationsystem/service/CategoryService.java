package com.example.restaurantinformationsystem.service;

import com.example.restaurantinformationsystem.dao.CategoryRepository;
import com.example.restaurantinformationsystem.dto.CategoryDto;
import com.example.restaurantinformationsystem.entity.Category;
import com.example.restaurantinformationsystem.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public Set<CategoryDto> getAllCategories() {
        Set<Category> categoriesEntities = categoryRepository.getAllByIdIsNotNull();
        if (categoriesEntities.isEmpty()) {
            throw new NullPointerException("No categories found");
        }
        return categoryMapper.mapToCategoryDto(categoriesEntities);
    }
}
