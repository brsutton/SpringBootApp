package com.sutton.rentalApp.model;

public class Unit {

    private int id;
    private int propertyId;
    private int tenantId;
    private int bedrooms;
    private int bathrooms;
    private int squareFeet;
    private String unitName;
    private String unitDescription;
    private double unitRent;
    private double backRent;
    private boolean occupied;
    private boolean maintenanceNeeded;
    private String maintenanceDescription;
    private double maintenanceCost;
    private double depositHeld;

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

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitDescription() {
        return unitDescription;
    }

    public void setUnitDescription(String unitDescription) {
        this.unitDescription = unitDescription;
    }

    public double getUnitRent() {
        return unitRent;
    }

    public void setUnitRent(double unitRent) {
        this.unitRent = unitRent;
    }

    public double getBackRent() {
        return backRent;
    }

    public void setBackRent(double backRent) {
        this.backRent = backRent;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isMaintenanceNeeded() {
        return maintenanceNeeded;
    }

    public void setMaintenanceNeeded(boolean maintenanceNeeded) {
        this.maintenanceNeeded = maintenanceNeeded;
    }

    public String getMaintenanceDescription() {
        return maintenanceDescription;
    }

    public void setMaintenanceDescription(String maintenanceDescription) {
        this.maintenanceDescription = maintenanceDescription;
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public double getDepositHeld() {
        return depositHeld;
    }

    public void setDepositHeld(double depositHeld) {
        this.depositHeld = depositHeld;
    }
}
