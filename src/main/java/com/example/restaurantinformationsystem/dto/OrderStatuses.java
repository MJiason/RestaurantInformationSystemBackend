package com.example.restaurantinformationsystem.dto;

import com.example.restaurantinformationsystem.entity.Enums.OrderStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class OrderStatuses implements Serializable {
    private Set<OrderStatus> orderStatuses;
}
