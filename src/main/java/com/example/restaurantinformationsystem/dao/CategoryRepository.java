package com.example.restaurantinformationsystem.dao;

import com.example.restaurantinformationsystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Set<Category> getAllByIdIsNotNull();
}
