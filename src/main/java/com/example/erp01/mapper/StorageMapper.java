package com.example.erp01.mapper;

import com.example.erp01.model.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
//@Repository
public interface StorageMapper {

    int inStore(List<Storage> storageList);

    int outStore(List<String> outstoreJson);

    int changeStore(String changestoreJson);

    List<Storage> getStorageState();

    List<String> storageReport(String storehouseLocation);

    List<String> getMatch(String subTailorQcode);

}
