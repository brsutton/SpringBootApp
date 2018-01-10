package com.sutton.rental.service;

import com.sutton.rental.dao.PhotoDao;
import com.sutton.rental.model.PropertyPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoDao photoDao;

    private final String FILE_PATH = "C:/propertyPhotos/";

    @Override
    public PropertyPhoto getPropertyPhotoByPropertyId(int propertyId) {
        return photoDao.getPropertyPhotoByPropertyId(propertyId);
    }

    @Override
    public boolean savePropertyPhotoImage(int propertyId, MultipartFile multipartFile) {
        boolean success = true;
        PropertyPhoto propertyPhoto = photoDao.getPropertyPhotoByPropertyId(propertyId);
        if (propertyPhoto.getId() == 0) {
            success = false;
        } else {
            propertyPhoto.setPhotoFileLocation(FILE_PATH + propertyId + ".jpg");
            try {
                photoDao.updatePropertyPhotoFileLocation(propertyPhoto);
                multipartFile.transferTo(new File(propertyPhoto.getPhotoFileLocation()));
                resizeImage(propertyPhoto);
            } catch (IOException e) {
                e.printStackTrace();
                success = false;
            }
        }
        return success;
    }

    @Override
    public boolean addPropertyPhoto(PropertyPhoto propertyPhoto) {
        return photoDao.addPropertyPhoto(propertyPhoto);
    }

    private void resizeImage(PropertyPhoto propertyPhoto) {
        try {
            BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
            img.createGraphics().drawImage(ImageIO
                    .read(new File(propertyPhoto.getPhotoFileLocation()))
                    .getScaledInstance(100, 100, Image.SCALE_SMOOTH), 0, 0, null);
            ImageIO.write(img, "jpg", new File(propertyPhoto.getPhotoFileLocation()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
