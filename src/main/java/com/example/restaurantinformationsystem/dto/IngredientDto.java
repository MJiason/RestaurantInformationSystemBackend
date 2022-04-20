package com.example.restaurantinformationsystem.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class IngredientDto implements Serializable {
    private long id;
    private String name;
    private String photo;
}
