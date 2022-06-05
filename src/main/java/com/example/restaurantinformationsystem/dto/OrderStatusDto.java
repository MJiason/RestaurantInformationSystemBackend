package com.example.restaurantinformationsystem.dto;

import com.example.restaurantinformationsystem.entity.Enums.OrderStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderStatusDto implements Serializable {
    private int id;
    private OrderStatus orderStatus;
}
