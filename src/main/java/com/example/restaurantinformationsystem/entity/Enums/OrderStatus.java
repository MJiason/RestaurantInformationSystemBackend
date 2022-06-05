package com.example.restaurantinformationsystem.entity.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum OrderStatus {
    NEW(0),
    ENTERING(1),
    READY(2),
    DELIVERED(3),
    FINISHED(4);

    public int getNum() {
        return num;
    }

    private final int num;

    OrderStatus(int num) {
        this.num = num;
    }

    @JsonCreator
    public static EntityType create(String value) {
        return EntityType.valueOf(value.toUpperCase());
    }
}
