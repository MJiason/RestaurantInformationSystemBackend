package com.example.restaurantinformationsystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "dish")
@Getter
@Setter
@RequiredArgsConstructor
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
    @Column(name = "photo", updatable = false)
    private String photo;
    @ManyToMany()
    private Set<IngredientEntity> ingredients;
    @OneToMany(mappedBy = "dish")
    Set<DishToOrder> orders = new java.util.LinkedHashSet<>();
}
