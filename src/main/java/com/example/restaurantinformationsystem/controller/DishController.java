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

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/dish")
    public void createDish(@RequestBody DishExtendedDto dishDto) {
        dishService.createDish(dishDto);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/dish")
    public void updateDish(@RequestBody DishExtendedDto dishDto) {
        dishService.updateDish(dishDto);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/dish/{id}")
    public void deleteDish(@PathVariable long id) {
        dishService.deleteDish(id);
    }
}
