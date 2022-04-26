package com.example.restaurantinformationsystem.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDto implements Serializable {
    private String name;
    private long id;
}
