package com.example.restaurantinformationsystem.entity.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EntityType {
    DISH,
    INGREDIENT;
    @JsonCreator
    public static EntityType create(String value) {
        return EntityType.valueOf(value.toUpperCase());
    }
}
