package com.example.erp01.service;

import com.example.erp01.model.EmbStore;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface EmbStoreService {

    int addEmbStore(EmbStore embStore);

    int deleteEmbStore(Integer storehouseID);

    int updateEmbStore(EmbStore embStore);

    List<EmbStore> getAllEmbStore();

    EmbStore getEmbStoreByLocation(String embStoreLocation);

}
