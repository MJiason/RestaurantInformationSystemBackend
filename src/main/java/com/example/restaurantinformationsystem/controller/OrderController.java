package com.example.restaurantinformationsystem.controller;

import com.example.restaurantinformationsystem.dto.OrderDto;
import com.example.restaurantinformationsystem.dto.OrderStatusDto;
import com.example.restaurantinformationsystem.dto.OrderStatuses;
import com.example.restaurantinformationsystem.entity.Enums.OrderStatus;
import com.example.restaurantinformationsystem.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/order/{id}")
    public OrderDto getOrdersById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/order")
    public Set<OrderDto> getOrderByStatus(@RequestParam OrderStatus status) {
        return orderService.getOrders(status);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/orders")
    public List<OrderDto> getOrderByStatuses(@RequestBody OrderStatuses statuses) {
        return orderService.getOrders(statuses.getOrderStatuses());
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/order/table/{id}")
    public List<OrderDto> getOrderByStatuses(@RequestBody OrderStatuses statuses, @PathVariable int id) {
        return orderService.getOrdersByNumberAndStatuses(statuses.getOrderStatuses(), id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/order")
    public void createOrder(@RequestBody OrderDto order) {
        orderService.saveOrder(order);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/order-status")
    public void setOrderStatus(@RequestBody OrderStatusDto statusDto) {
       orderService.setOrderStatus(statusDto);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/order/close")
    public void setOrderStatus(@RequestParam int tableNum) {
        orderService.setOrderStatus(tableNum);
    }
}
