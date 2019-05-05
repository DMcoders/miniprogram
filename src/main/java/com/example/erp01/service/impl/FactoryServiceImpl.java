package com.example.erp01.service.impl;

import com.example.erp01.mapper.FactoryMapper;
import com.example.erp01.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactoryServiceImpl implements FactoryService {
    @Autowired
    private FactoryMapper factoryMapper;


    @Override
    public String getAddressByFactoryCode(String factoryCode) {
        try{
            String address = factoryMapper.getAddressByFactoryCode(factoryCode);
            return address;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
