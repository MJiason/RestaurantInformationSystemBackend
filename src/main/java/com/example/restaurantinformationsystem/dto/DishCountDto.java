package com.example.restaurantinformationsystem.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DishCountDto implements Serializable {
    private DishDto dish;
    private int count;
}
