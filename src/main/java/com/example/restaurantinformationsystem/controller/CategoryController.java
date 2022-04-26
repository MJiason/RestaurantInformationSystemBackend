package com.example.restaurantinformationsystem.controller;

import com.example.restaurantinformationsystem.dto.CategoryDto;
import com.example.restaurantinformationsystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/category")
    public Set<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
