package com.example.restaurantinformationsystem.controller;

import com.example.restaurantinformationsystem.dto.OrderDto;
import com.example.restaurantinformationsystem.dto.OrderStatuses;
import com.example.restaurantinformationsystem.entity.Enums.OrderStatus;
import com.example.restaurantinformationsystem.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@AllArgsConstructor
public class OrderController {
    private final OrderService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/order/{id}")
    public OrderDto getOrdersById(@PathVariable int id) {
        return service.getOrderById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/order")
    public Set<OrderDto> getOrderByStatus(@RequestParam OrderStatus status) {
        return service.getOrders(status);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/orders")
    public Set<OrderDto> getOrderByStatuses(@RequestBody OrderStatuses statuses) {
        return service.getOrders(statuses.getOrderStatuses());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/order")
    public void createOrder(@RequestBody OrderDto order) {
        service.saveOrder(order);
    }
}
