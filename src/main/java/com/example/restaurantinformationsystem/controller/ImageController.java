package com.example.restaurantinformationsystem.controller;


import com.example.restaurantinformationsystem.dto.SavePhotoDto;
import com.example.restaurantinformationsystem.service.AwsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@RestController@RequiredArgsConstructor
public class ImageController {
    private final AwsService imageService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/images" )
    public void addPhoto(@RequestPart SavePhotoDto savePhotoDto,
                         @RequestPart(name = "image")MultipartFile img) throws IOException {
        imageService.save(img, savePhotoDto);
    }
}
