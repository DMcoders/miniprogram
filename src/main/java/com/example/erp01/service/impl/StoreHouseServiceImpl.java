package com.example.erp01.service.impl;

import com.example.erp01.mapper.StoreHouseMapper;
import com.example.erp01.model.StoreHouse;
import com.example.erp01.service.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StoreHouseServiceImpl implements StoreHouseService {
    @Autowired
    private StoreHouseMapper storeHouseMapper;

    @Override
    public int addStoreHouse(StoreHouse storeHouse) {
        try{
            storeHouseMapper.addStoreHouse(storeHouse);
            return 0;
        } catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteStoreHouse(Integer storehouseID) {
        try{
            storeHouseMapper.deleteStoreHouse(storehouseID);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<StoreHouse> getAllStoreHouse() {
        List<StoreHouse> storeHouseList = null;
        try{
            storeHouseList = storeHouseMapper.getAllStoreHouse();
            return storeHouseList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StoreHouse getStoreHouseByLocation(String storehouseLocation) {
        try{
            return storeHouseMapper.getStoreHouseByLocation(storehouseLocation);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateStoreHouse(StoreHouse storeHouse) {
        try{
            storeHouseMapper.updateStoreHouse(storeHouse);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }


}
