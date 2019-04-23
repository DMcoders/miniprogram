package com.example.erp01.service;

import com.example.erp01.model.StoreHouse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//@Service
public interface StoreHouseService {

    int addStoreHouse(StoreHouse storeHouse);

    int deleteStoreHouse(Integer storehouseID);

    int updateStoreHouse(StoreHouse storeHouse);

    List<StoreHouse> getAllStoreHouse();

    StoreHouse getStoreHouseByLocation(String storehouseLocation);

}
