package com.example.erp01.mapper;

import com.example.erp01.model.Wrong;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface WrongMapper {

    int addWrong(Wrong wrong);

    int deleteWrong(Integer wrongCodeID);

    List<Wrong> getAllWrong();

}
