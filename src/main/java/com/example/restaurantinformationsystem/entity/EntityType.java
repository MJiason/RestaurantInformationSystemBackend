package com.example.restaurantinformationsystem.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Locale;
import java.util.stream.Stream;

public enum EntityType {
    DISH,
    INGREDIENT;



//    @Override
//    public String toString() {
//        return this.EntityType;
//    }

    @JsonCreator
    public static EntityType create(String value) {
        return EntityType.valueOf(value.toUpperCase());
    }
}
