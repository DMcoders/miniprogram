package com.example.erp01.service;

import com.example.erp01.model.Storage;

import java.util.List;

//@Service
public interface StorageService {

    int inStore(List<Storage> storageList);

    int outStore(List<String> outstoreJson);

    int changeStore(String changestoreJson);

    List<Storage> getStorageState();

    List<String> storageReport(String storehouseLocation);

    List<String> getMatch(String subTailorQcode);
}
