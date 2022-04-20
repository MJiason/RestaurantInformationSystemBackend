package com.example.restaurantinformationsystem.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Set;

@Data
public class DishExtendedDto implements Serializable {
    private long id;
    private String name;
    private String category;
    private int weight;
    private int calories;
    private int price;
    @Max(100)
    @PositiveOrZero(message = "Discount must be positive")
    private int discount;
    private String photo;
    private Set<IngredientDto> ingredients;

    public void setIngredients(Set<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    public void setCategory(String categoryName) {
        this.category = categoryName;
    }
}
