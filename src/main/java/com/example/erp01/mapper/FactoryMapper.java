package com.example.erp01.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FactoryMapper {

    String getAddressByFactoryCode(String factoryCode);

}
