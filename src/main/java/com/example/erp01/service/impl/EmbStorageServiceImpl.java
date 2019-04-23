package com.example.erp01.service.impl;

import com.example.erp01.mapper.EmbStorageMapper;
import com.example.erp01.model.EmbStorage;
import com.example.erp01.service.EmbStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmbStorageServiceImpl implements EmbStorageService {
    @Autowired
    private EmbStorageMapper embStorageMapper;

    @Override
    public int embInStore(List<EmbStorage> embStorageList) {
        try{
            embStorageMapper.embInStore(embStorageList);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int embOutStore(List<String> embOutStoreList) {
        try{
            embStorageMapper.embOutStore(embOutStoreList);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int embChangeStore(String embChangeStoreJson) {
        try{
            embStorageMapper.embChangeStore(embChangeStoreJson);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<EmbStorage> getEmbStorageState() {
        try{
            List<EmbStorage> embStorageList = new ArrayList<>();

            embStorageList = embStorageMapper.getEmbStorageState();

            return embStorageList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> embStorageQuery(String orderName, String colorName, Integer bedNumber, String sizeName) {
        List<Object> queryResult = new ArrayList<>();
        try{
            queryResult = embStorageMapper.embStorageQuery(orderName, colorName, bedNumber, sizeName);
            return queryResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return queryResult;
    }
}
