package com.example.erp01.model;

public class Storage {

    private Integer storageID;

    private String storehouseLocation;

    private String tailorQcode;

    private Integer storageState;

    private Integer storehouseCount;

    public String getStorehouseLocation() {
        return storehouseLocation;
    }

    public void setStorehouseLocation(String storehouseLocation) {
        this.storehouseLocation = storehouseLocation;
    }

    public Integer getStorehouseCount() {
        return storehouseCount;
    }

    public void setStorehouseCount(Integer storehouseCount) {
        this.storehouseCount = storehouseCount;
    }

    public Storage(String storehouseLocation, Integer storageState, Integer storehouseCount) {
        this.storehouseLocation = storehouseLocation;
        this.storageState = storageState;
        this.storehouseCount = storehouseCount;
    }

    public Storage() {
    }

    public Storage(Integer storageID, String storehouseLocation, String tailorQcode, Integer storageState) {
        this.storageID = storageID;
        this.storehouseLocation = storehouseLocation;
        this.tailorQcode = tailorQcode;
        this.storageState = storageState;
    }

    public Storage(String storehouseLocation, Integer storageState) {
        this.storehouseLocation = storehouseLocation;
        this.storageState = storageState;
    }

    public Integer getStorageState() {
        return storageState;
    }

    public void setStorageState(Integer storageState) {
        this.storageState = storageState;
    }

    public Storage(String storehouseLocation, String tailorQcode) {
        this.storehouseLocation = storehouseLocation;
        this.tailorQcode = tailorQcode;
    }

    public Integer getStorageID() {
        return storageID;
    }

    public void setStorageID(Integer storageID) {
        this.storageID = storageID;
    }

    public String getTailorQcode() {
        return tailorQcode;
    }

    public void setTailorQcode(String tailorQcode) {
        this.tailorQcode = tailorQcode;
    }
}
