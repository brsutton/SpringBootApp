package com.sutton.rental.controller;

import com.sutton.rental.model.PropertyPhoto;
import com.sutton.rental.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @RequestMapping(value = Urls.PROPERTY_PHOTO_URL, method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getPropertyPhoto(@PathVariable("propertyId") int propertyId) {

        PropertyPhoto propertyPhoto = photoService.getPropertyPhotoByPropertyId(propertyId);
        byte[] bytes = new byte[0];

        try {
            File file = new File(propertyPhoto.getPhotoFileLocation());
            bytes = Files.readAllBytes(file.toPath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

}
