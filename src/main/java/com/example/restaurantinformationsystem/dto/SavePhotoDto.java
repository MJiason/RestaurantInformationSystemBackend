package com.example.restaurantinformationsystem.dto;

import com.example.restaurantinformationsystem.entity.Enums.EntityType;
import lombok.Data;

@Data
public class SavePhotoDto {
    private long id;
    private EntityType entityName;
}


