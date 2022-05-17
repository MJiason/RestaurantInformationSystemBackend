package com.example.restaurantinformationsystem.dao;

import com.example.restaurantinformationsystem.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Set;

public interface DishRepository extends JpaRepository<DishEntity, Long> {
    DishEntity getById(long id);
    Set<DishEntity> findAllByCategory_Name(String categoryName);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update dish set photo = :url  where id = :id")
    void setPhotoToDish(@Param("url") String url, @Param("id") long id);
}
