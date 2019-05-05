package com.example.erp01.model;

public class Factory {

    private Integer factoryID;

    private String factoryNumber;

    private String address;

    public Factory(String factoryNumber, String address) {
        this.factoryNumber = factoryNumber;
        this.address = address;
    }

    public Factory(Integer factoryID, String factoryNumber, String address) {
        this.factoryID = factoryID;
        this.factoryNumber = factoryNumber;
        this.address = address;
    }

    public Factory() {
    }

    public Integer getFactoryID() {
        return factoryID;
    }

    public void setFactoryID(Integer factoryID) {
        this.factoryID = factoryID;
    }

    public String getFactoryNumber() {
        return factoryNumber;
    }

    public void setFactoryNumber(String factoryNumber) {
        this.factoryNumber = factoryNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
