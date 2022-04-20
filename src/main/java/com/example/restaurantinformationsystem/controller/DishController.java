package com.example.restaurantinformationsystem.controller;

import com.example.restaurantinformationsystem.dto.DishExtendedDto;
import com.example.restaurantinformationsystem.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;

    @GetMapping("/dish/{id}")
    public DishExtendedDto getDishById(@PathVariable long id) {
        return dishService.detDishById(id);
    }
}
