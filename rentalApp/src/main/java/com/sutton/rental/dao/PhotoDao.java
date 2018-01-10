package com.sutton.rental.dao;

import com.sutton.rental.model.PropertyPhoto;

public interface PhotoDao {

    public PropertyPhoto getPropertyPhotoByPropertyId(int propertyId);


}
