package com.example.restaurantinformationsystem.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "dish")
@Getter
@Setter
public class DishEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    private Category category;
    @Column(nullable = false)
    private int weight;
    @Column(nullable = false)
    private int price;
    @Max(100) @PositiveOrZero(message = "Discount must be positive")
    @Column(nullable = false)
    private int discount;
    @Column(nullable = false)
    private int calories;
    private String photo;
    @ManyToMany()
    private Set<IngredientEntity> ingredients;
}
