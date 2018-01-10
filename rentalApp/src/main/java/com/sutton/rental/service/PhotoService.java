package com.sutton.rental.service;

import com.sutton.rental.model.PropertyPhoto;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {

    public PropertyPhoto getPropertyPhotoByPropertyId(int propertyId);

    public boolean savePropertyPhotoImage(int propertyId, MultipartFile multipartFile);

    public boolean addPropertyPhoto(PropertyPhoto propertyPhoto);

}
