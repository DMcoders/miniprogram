package com.example.erp01.model;

import org.apache.ibatis.type.DateTypeHandler;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Date;

public class StoreHouse {

    private Integer storehouseID;

    private String storehouseLocation;

    private Integer storehouseCount;


    public StoreHouse(String storehouseLocation, Integer storehouseCount) {
        this.storehouseLocation = storehouseLocation;
        this.storehouseCount = storehouseCount;
    }

    public StoreHouse() {
    }

    public StoreHouse(Integer storehouseID, String storehouseLocation, Integer storehouseCount) {
        this.storehouseID = storehouseID;
        this.storehouseLocation = storehouseLocation;
        this.storehouseCount = storehouseCount;
    }

    public Integer getStorehouseID() {
        return storehouseID;
    }

    public void setStorehouseID(Integer storehouseID) {
        this.storehouseID = storehouseID;
    }

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
}
