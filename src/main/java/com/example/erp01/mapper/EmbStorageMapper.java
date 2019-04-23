package com.example.erp01.mapper;

import com.example.erp01.model.EmbStorage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
//@Repository
public interface EmbStorageMapper {

    int embInStore(List<EmbStorage> embStorageList);

    int embOutStore(List<String> embOutStoreList);

    int embChangeStore(String embChangeStoreJson);

    List<EmbStorage> getEmbStorageState();

    List<Object> embStorageQuery(@Param("orderName")String orderName, @Param("colorName")String colorName, @Param("bedNumber")Integer bedNumber, @Param("sizeName")String sizeName);

}
