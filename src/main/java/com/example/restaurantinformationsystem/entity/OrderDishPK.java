package com.example.restaurantinformationsystem.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import java.io.Serializable;

@Data
@Embeddable
public class OrderDishPK implements Serializable {

    public OrderDishPK() {
    }

    @Column(name = "dish_id", nullable = false)
    private long dish_id;

    @Column(name = "order_id")
    private long order_id;
}
