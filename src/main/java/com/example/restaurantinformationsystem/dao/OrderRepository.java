package com.example.restaurantinformationsystem.dao;

import com.example.restaurantinformationsystem.entity.Enums.OrderStatus;
import com.example.restaurantinformationsystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Set<Order> getOrderByOrderStatusOrderByIdAsc(OrderStatus status);

    @Query(nativeQuery = true, value = "select * from orders where order_status in (:statuses) order by id")
    List<Order> getOrderByStatus(@Param("statuses") Set<Integer> statuses);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update orders set order_status = :status where id = :id")
    void setOrderStatus(@Param("status") int status, @Param("id") int id);



    @Query(nativeQuery = true, value = "select * from orders where orders.table_num = :table order by id")
    List<Order> getOrdersByTable(@Param("table") int tableNum);


    @Query(nativeQuery = true, value = "select * from orders where orders.table_num = :table  " +
            "and order_status in (:statuses) order by id")
    List<Order> getOrdersByTableAndStatuses(@Param("table") int tableNum, @Param("statuses") Set<Integer> statuses);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update orders set order_status = 4 where table_num = :id AND order_status != 4")
    void closeOrder( @Param("id") int id);

}
