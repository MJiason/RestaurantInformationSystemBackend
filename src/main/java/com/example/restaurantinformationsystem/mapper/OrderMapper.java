package com.example.restaurantinformationsystem.mapper;

import com.example.restaurantinformationsystem.dto.DishCountDto;
import com.example.restaurantinformationsystem.dto.OrderDto;
import com.example.restaurantinformationsystem.entity.DishToOrder;
import com.example.restaurantinformationsystem.entity.Order;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component

public class OrderMapper {
    private final ModelMapper modelMapper;
    private final DishMapper dishMapper;

    public OrderMapper(ModelMapper modelMapper, DishMapper dishMapper) {
        this.modelMapper = modelMapper;
        this.dishMapper = dishMapper;
        this.modelMapper.addMappings(skipFieldMapDto);
        this.modelMapper.addMappings(skipFieldMapEntity);
    }

    PropertyMap<Order, OrderDto> skipFieldMapDto = new PropertyMap<>() {
        @Override
        protected void configure() {
            skip().setDishes(null);
        }
    };
    PropertyMap<OrderDto, Order> skipFieldMapEntity = new PropertyMap<>() {
        @Override
        protected void configure() {
            skip().setDishes(null);
        }
    };

    public OrderDto mapToOrderDto(Order order) {
        OrderDto orderDto = modelMapper.map(Hibernate.unproxy(order), OrderDto.class);
        Set<DishCountDto> dishDtos = new HashSet<>();
        for (DishToOrder dish : order.getDishes()) {
            DishCountDto dishCountDto = new DishCountDto();
            dishCountDto.setCount(dish.getCount());
            dishCountDto.setDish(dishMapper.mapToDishDto(dish.getDish()));
            dishDtos.add(dishCountDto);
        }
        orderDto.setDishes(dishDtos);
        return orderDto;
    }

    public Order mapToOrderEntity(OrderDto orderDto){
        Order order = modelMapper.map(orderDto, Order.class);
        return order;
    }
}
