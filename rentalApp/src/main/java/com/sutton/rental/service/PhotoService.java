package com.sutton.rental.service;

import com.sutton.rental.model.PropertyPhoto;

public interface PhotoService {

    public PropertyPhoto getPropertyPhotoByPropertyId(int propertyId);

}
