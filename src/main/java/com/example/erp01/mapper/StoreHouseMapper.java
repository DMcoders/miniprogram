package com.example.erp01.mapper;

import com.example.erp01.model.StoreHouse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
//@Repository
public interface StoreHouseMapper {

    int addStoreHouse(StoreHouse storeHouse);

    int deleteStoreHouse(Integer storehouseID);

    int updateStoreHouse(StoreHouse storeHouse);

    List<StoreHouse> getAllStoreHouse();

    StoreHouse getStoreHouseByLocation(String storehouseLocation);


}
