package com.sutton.rental.model;

public class PropertyPhoto {

    private int id;
    private int propertyId;
    private String photoFileLocation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPhotoFileLocation() {
        return photoFileLocation;
    }

    public void setPhotoFileLocation(String photoFileLocation) {
        this.photoFileLocation = photoFileLocation;
    }
}
