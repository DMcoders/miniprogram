package com.example.erp01.service.impl;

import com.example.erp01.mapper.EmbStoreMapper;
import com.example.erp01.model.EmbStore;
import com.example.erp01.service.EmbStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmbStoreServiceImpl implements EmbStoreService {

    @Autowired
    private EmbStoreMapper embStoreMapper;

    @Override
    public int addEmbStore(EmbStore embStore) {
        try{
            embStoreMapper.addEmbStore(embStore);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteEmbStore(Integer storehouseID) {
        try{
            embStoreMapper.deleteEmbStore(storehouseID);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int updateEmbStore(EmbStore embStore) {
        try{
            embStoreMapper.updateEmbStore(embStore);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<EmbStore> getAllEmbStore() {
        List<EmbStore> embStoreList = new ArrayList<>();
        try{
            embStoreList = embStoreMapper.getAllEmbStore();
            return embStoreList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EmbStore getEmbStoreByLocation(String embStoreLocation) {
        try{
            return embStoreMapper.getEmbStoreByLocation(embStoreLocation);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
