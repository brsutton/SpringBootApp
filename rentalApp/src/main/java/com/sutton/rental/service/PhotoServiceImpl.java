package com.sutton.rental.service;

import com.sutton.rental.dao.PhotoDao;
import com.sutton.rental.model.PropertyPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoDao photoDao;

    @Override
    public PropertyPhoto getPropertyPhotoByPropertyId(int propertyId) {
        return photoDao.getPropertyPhotoByPropertyId(propertyId);
    }
}
