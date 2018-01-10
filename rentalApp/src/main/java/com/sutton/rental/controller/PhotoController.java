package com.sutton.rental.controller;

import com.sutton.rental.model.PropertyPhoto;
import com.sutton.rental.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

@RestController
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @RequestMapping(value = Urls.PROPERTY_PHOTO_URL + "/{propertyId}",
            method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getPropertyPhoto(@PathVariable("propertyId") int propertyId) {

        PropertyPhoto propertyPhoto = photoService.getPropertyPhotoByPropertyId(propertyId);
        byte[] bytes = new byte[0];

        try {

            File file = new File(propertyPhoto.getPhotoFileLocation());
            bytes = Files.readAllBytes(file.toPath());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    @RequestMapping(value = Urls.PROPERTY_PHOTO_URL + "/{propertyId}", method = RequestMethod.PUT)
    public boolean uploadPropertyPhoto(@PathVariable("propertyId") int propertyId,
                                       @RequestParam("image") MultipartFile image) {

        return photoService.savePropertyPhotoImage(propertyId, image);
    }

    @RequestMapping(value = Urls.PROPERTY_PHOTO_URL, method = RequestMethod.PUT)
    public boolean addPropertyPhoto(@RequestBody PropertyPhoto propertyPhoto){
        return photoService.addPropertyPhoto(propertyPhoto);
    }

}
