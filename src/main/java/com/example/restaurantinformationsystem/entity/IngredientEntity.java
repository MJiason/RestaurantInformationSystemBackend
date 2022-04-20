package com.example.restaurantinformationsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ingredient")
@Getter
@Setter
public class IngredientEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    @Column
    private String name;
    @Column
    private String photo;
    @Column
    private String measurement;
    @Column
    private long count;
    @Column
    private long price;
    @Column
    private long calories;

}
