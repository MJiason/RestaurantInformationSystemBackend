package com.example.restaurantinformationsystem.dto;

import com.example.restaurantinformationsystem.entity.IngredientEntity;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class DishDto implements Serializable {
    private long id;
    private String name;
    private String category;
    private int weight;
    private int price;
    @Max(100)
    @PositiveOrZero(message = "Discount must be positive")
    private int discount;
    private String photo;
    private Set<String> ingredients;


    public void setIngredients(Set<IngredientEntity> ingredients) {
        Set<String> ingredientsSet = new HashSet<>();

        for (IngredientEntity ingredient : ingredients) {
            ingredientsSet.add(ingredient.getName());
        }

        this.ingredients = ingredientsSet;
    }
}
