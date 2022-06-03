package com.example.restaurantinformationsystem.dto;

import com.example.restaurantinformationsystem.entity.Enums.OrderStatus;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Data
public class OrderDto implements Serializable {
    private int id;
    private int tableNum;
    private Timestamp time;
    private String comment;
    private OrderStatus orderStatus;
    private Set<DishCountDto> dishes;

    public void setDishes(Set<DishCountDto> dishes) {
        this.dishes = dishes;
    }
}
