package com.example.restaurantinformationsystem.dao;

import com.example.restaurantinformationsystem.entity.Enums.OrderStatus;
import com.example.restaurantinformationsystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Set<Order> getOrderByOrderStatusOrderByIdAsc(OrderStatus status);

    @Query(nativeQuery = true, value = "select * from orders where order_status in (:statuses)")
    Set<Order> getOrderByStatus(@Param("statuses") Set<Integer> statuses);
}
