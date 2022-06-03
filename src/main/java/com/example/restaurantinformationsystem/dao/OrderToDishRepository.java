package com.example.restaurantinformationsystem.dao;

import com.example.restaurantinformationsystem.entity.DishToOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface OrderToDishRepository extends JpaRepository<DishToOrder, Long> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =
            "insert into dish_to_order " +
            "(dish_id, order_id, count) " +
            "VALUES (:dishId, :orderId, :count)")
    void saveOrderTDish(@Param("dishId") long dishId, @Param("orderId") long orderId, @Param("count") int count);
}
