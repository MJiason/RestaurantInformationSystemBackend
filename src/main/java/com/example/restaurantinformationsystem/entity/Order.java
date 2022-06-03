package com.example.restaurantinformationsystem.entity;

import com.example.restaurantinformationsystem.entity.Enums.OrderStatus;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;
    private int tableNum;
    private Timestamp time;
    private String comment;
    private OrderStatus orderStatus;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    Set<DishToOrder> dishes = new java.util.LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
