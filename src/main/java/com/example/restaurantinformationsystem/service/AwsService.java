package com.example.restaurantinformationsystem.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.example.restaurantinformationsystem.dao.DishRepository;
import com.example.restaurantinformationsystem.dto.SavePhotoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Slf4j
@Service
@PropertySource("classpath:aws.service.properties")
public class AwsService {
    private final String accessKey;
    private final String secretKey;
    private final String bucketName;
    private final AmazonS3 s3client;
    private final DishRepository dishRepository;

    public AwsService(@Value("${aws.service.access-key}") String accessKey,
                      @Value("${aws.service.secret-key}") String secretKey,
                      @Value("${aws.service.bucket-name}") String bucketName,
                      DishRepository dishRepository) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.bucketName = bucketName;
        this.dishRepository = dishRepository;


        AWSCredentials credentials = new BasicAWSCredentials(
                this.accessKey,
                this.secretKey
        );

        this.s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.EU_WEST_2)
                .build();
    }

    public void save(MultipartFile img, SavePhotoDto savePhotoDto) throws IOException {
        if (img.isEmpty()) {
            throw new IllegalArgumentException("Empty image");
        }
        String photoName = imageGetName(savePhotoDto, img);
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + img.getName());
        img.transferTo(convFile);
        s3client.putObject(bucketName, photoName, convFile);
        String url = getUrl(photoName);
        saveUrlToDb(url, savePhotoDto);
        log.info("image saved to AWS");
    }

    public String getUrl(String fileName) {
        return s3client.getUrl(bucketName, fileName).toString();
    }

    private void saveUrlToDb(String url, SavePhotoDto savePhotoDto) {
        switch (savePhotoDto.getEntityName()) {
            case DISH:
                dishRepository.setPhotoToDish(url, savePhotoDto.getId());
                break;
            case INGREDIENT:
                //TODO save ingredient
                break;
            default:
                throw new IllegalArgumentException("unknown entity type " + savePhotoDto.getEntityName());
        }
    }

    private String getPhotoExtensionByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("image not present");
        }
        return name.substring(name.lastIndexOf('.'));
    }

    private String imageGetName(SavePhotoDto savePhotoDto, MultipartFile img) {
        return savePhotoDto.getId()
                + savePhotoDto.getEntityName().toString()
                + getPhotoExtensionByName(img.getOriginalFilename());
    }
}
