package com.example.restaurantinformationsystem.service;

import com.example.restaurantinformationsystem.dao.OrderRepository;
import com.example.restaurantinformationsystem.dao.OrderToDishRepository;
import com.example.restaurantinformationsystem.dto.DishCountDto;
import com.example.restaurantinformationsystem.dto.OrderDto;
import com.example.restaurantinformationsystem.entity.DishEntity;
import com.example.restaurantinformationsystem.entity.DishToOrder;
import com.example.restaurantinformationsystem.entity.Enums.OrderStatus;
import com.example.restaurantinformationsystem.entity.Order;
import com.example.restaurantinformationsystem.entity.OrderDishPK;
import com.example.restaurantinformationsystem.mapper.DishMapper;
import com.example.restaurantinformationsystem.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final OrderToDishRepository orderToDishRepository;
    private final OrderMapper orderMapper;
    private final DishMapper dishMapper;

    public OrderDto getOrderById(int id) {
        return orderMapper.mapToOrderDto(repository.getById(id));
    }

    public Set<OrderDto> getOrders (OrderStatus orderStatus) {
        if (orderStatus == null) {
            throw new IllegalArgumentException("Missing order status param");
        }
        Set<Order> ordersEntities = repository.getOrderByOrderStatusOrderByIdAsc(orderStatus);
        Set<OrderDto> orders = new HashSet<>();
        for (Order ordersEntity : ordersEntities) {
            orders.add(orderMapper.mapToOrderDto(ordersEntity));
        }
        return orders;
    }

    public Set<OrderDto> getOrders (Set<OrderStatus> statuses) {
        if (statuses.isEmpty()) {
            throw new IllegalArgumentException("Missing order status param");
        }
        Set<Order> ordersEntities = repository.getOrderByStatus(orderStatusesToInt(statuses));
        Set<OrderDto> orders = new HashSet<>();
        for (Order ordersEntity : ordersEntities) {
            orders.add(orderMapper.mapToOrderDto(ordersEntity));
        }
        return orders;
    }
    @Transactional
    public void saveOrder(OrderDto order) {
        int orderId = repository.save(orderMapper.mapToOrderEntity(order)).getId();
        for (DishCountDto dish : order.getDishes()) {
            orderToDishRepository.saveOrderTDish(dish.getDish().getId(),orderId ,dish.getCount());
        }
    }

    private Set<Integer> orderStatusesToInt(Set<OrderStatus> statuses) {
        Set<Integer> integerSet = new HashSet<>();
        for (OrderStatus status : statuses) {
            integerSet.add(status.getNum());
        }
        return integerSet;
    }
}
