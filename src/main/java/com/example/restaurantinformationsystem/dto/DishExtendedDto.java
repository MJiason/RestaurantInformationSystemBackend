package com.example.restaurantinformationsystem.dto;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Set;

@Data
public class DishExtendedDto implements Serializable {
    private long id;
    private String name;
    private CategoryDto category;
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
}
