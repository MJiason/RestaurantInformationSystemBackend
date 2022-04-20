package com.example.restaurantinformationsystem.service;

import com.example.restaurantinformationsystem.dao.DishRepository;
import com.example.restaurantinformationsystem.dto.DishDto;
import com.example.restaurantinformationsystem.dto.DishExtendedDto;
import com.example.restaurantinformationsystem.mapper.DishMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    public Set<DishDto> getAllDishes() {
        return null;
    }

    public DishExtendedDto detDishById(long id) {
        if (id < 0) {
            throw new IllegalArgumentException("dish id can`t be negative");
        }

        if (id >= Long.MAX_VALUE) {
            throw new IllegalArgumentException("dish id gather maximal limit");
        }

        return dishMapper.mapToDishExtendedDto(dishRepository.getById(id));
    }
}
