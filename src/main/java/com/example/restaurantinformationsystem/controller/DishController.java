package com.example.restaurantinformationsystem.controller;

import com.example.restaurantinformationsystem.dto.DishDto;
import com.example.restaurantinformationsystem.dto.DishExtendedDto;
import com.example.restaurantinformationsystem.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/dish")
    public Set<DishDto> getAllDishes(@RequestParam String category){
        return dishService.getAllDishes(category);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/dish/{id}")
    public DishExtendedDto getDishById(@PathVariable long id) {
        return dishService.detDishById(id);
    }
}
