package com.example.restaurantinformationsystem.dto;

import com.example.restaurantinformationsystem.entity.EntityType;
import lombok.Data;


import java.io.Serializable;

@Data
public class SavePhotoDto {
    private long id;
    private EntityType entityName;
}


