package com.example.restaurantinformationsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter

@Entity
public class DishToOrder implements Serializable {

    @EmbeddedId
    private OrderDishPK id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @MapsId("dish_id")
    @JoinColumn(name = "dish_id")
    private DishEntity dish;

    @ManyToOne(cascade = {CascadeType.ALL})
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;
    private int count;
}
