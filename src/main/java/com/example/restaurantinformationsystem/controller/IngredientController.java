package com.example.restaurantinformationsystem.controller;

import com.example.restaurantinformationsystem.dto.IngredientDto;
import com.example.restaurantinformationsystem.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class IngredientController {
    final IngredientService ingredientService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/ingredient")
    public Set<IngredientDto> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }
}
