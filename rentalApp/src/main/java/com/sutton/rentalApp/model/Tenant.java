package com.sutton.rentalApp.model;

import java.time.LocalDate;

public class Tenant {

    private int id;
    private int unitId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate moveInDate;
    private LocalDate leaseExpires;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(String moveInDate) {
        this.moveInDate = LocalDate.parse(moveInDate);
    }

    public LocalDate getLeaseExpires() {
        return leaseExpires;
    }

    public void setLeaseExpires(String leaseExpires) {
        this.leaseExpires = LocalDate.parse(leaseExpires);
    }
}
