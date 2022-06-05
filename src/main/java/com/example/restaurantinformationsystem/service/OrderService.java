package com.example.restaurantinformationsystem.service;

import com.example.restaurantinformationsystem.dao.OrderRepository;
import com.example.restaurantinformationsystem.dao.OrderToDishRepository;
import com.example.restaurantinformationsystem.dto.DishCountDto;
import com.example.restaurantinformationsystem.dto.OrderDto;
import com.example.restaurantinformationsystem.dto.OrderStatusDto;
import com.example.restaurantinformationsystem.entity.Enums.OrderStatus;
import com.example.restaurantinformationsystem.entity.Order;

import com.example.restaurantinformationsystem.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderToDishRepository orderToDishRepository;
    private final OrderMapper orderMapper;

    public OrderDto getOrderById(int id) {
        return orderMapper.mapToOrderDto(orderRepository.getById(id));
    }

    public Set<OrderDto> getOrders(OrderStatus orderStatus) {
        if (orderStatus == null) {
            throw new IllegalArgumentException("Missing order status param");
        }
        Set<Order> ordersEntities = orderRepository.getOrderByOrderStatusOrderByIdAsc(orderStatus);
        Set<OrderDto> orders = new HashSet<>();
        for (Order ordersEntity : ordersEntities) {
            orders.add(orderMapper.mapToOrderDto(ordersEntity));
        }
        return orders;
    }

    public List<OrderDto> getOrders(Set<OrderStatus> statuses) {
        if (statuses.isEmpty()) {
            throw new IllegalArgumentException("Missing order status param");
        }
        List<Order> ordersEntities = orderRepository.getOrderByStatus(orderStatusesToInt(statuses));
        List<OrderDto> orders = new ArrayList<>();
        for (Order ordersEntity : ordersEntities) {
            orders.add(orderMapper.mapToOrderDto(ordersEntity));
        }
        return orders;
    }


    public List<OrderDto> getOrdersByNumberAndStatuses(Set<OrderStatus> statuses, int tableNum) {
        if (statuses.isEmpty()) {
            throw new IllegalArgumentException("Missing order status param");
        }
        List<Order> ordersEntities = orderRepository.getOrdersByTableAndStatuses(tableNum, orderStatusesToInt(statuses));
        List<OrderDto> orders = new ArrayList<>();
        for (Order ordersEntity : ordersEntities) {
            orders.add(orderMapper.mapToOrderDto(ordersEntity));
        }
        return orders;
    }

    @Transactional
    public void saveOrder(OrderDto order) {
        int orderId = orderRepository.save(orderMapper.mapToOrderEntity(order)).getId();
        for (DishCountDto dish : order.getDishes()) {
            orderToDishRepository.saveOrderTDish(dish.getDish().getId(), orderId, dish.getCount());
        }
    }

    public void setOrderStatus(OrderStatusDto statusDto) {
        if (statusDto.getOrderStatus() == null) {
            throw new IllegalArgumentException("Missing order status param");
        }
        if (!orderRepository.existsById(statusDto.getId())) {
            throw new NoSuchElementException("Missing order with id " + statusDto.getId());
        }
        orderRepository.setOrderStatus(statusDto.getOrderStatus().getNum(), statusDto.getId());
    }

    public void setOrderStatus(int tableNum) {
        orderRepository.closeOrder(tableNum);
    }

    private Set<Integer> orderStatusesToInt(Set<OrderStatus> statuses) {
        Set<Integer> integerSet = new HashSet<>();
        for (OrderStatus status : statuses) {
            integerSet.add(status.getNum());
        }
        return integerSet;
    }
}
