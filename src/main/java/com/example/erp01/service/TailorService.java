package com.example.erp01.service;

import com.example.erp01.model.CutQueryLeak;
import com.example.erp01.model.Tailor;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;

public interface TailorService {

    List<Tailor> generateTailorData(String jsonStr);

    int saveTailorData(List<Tailor> tailorList);

    List<Tailor> getAllTailorData();

    List<Tailor> getAllTailorDataByOrder(String orderName);

    Integer getMaxBedNumber(String orderName);

    List<Tailor> getTailorByOrderNameBedNum(String orderName,int bedNumber);

    List<Tailor> getTailorByOrderNameBedNumSizeColorPart(String orderName, int bedNumber, String sizeName, String colorName,String partName);

    int getTailorCountByOrderNameBedNum(String orderName,int bedNumber);

    List<Integer> getBedNumbersByOrderName(String orderName);

    List<String> getSizeNamesByOrderName(String orderName);

    List<String> getPartNamesByOrderName(@Param("orderName")String orderName);

    Integer getTailorCountByOrderNameBedNumPart(String orderName,int bedNumber,String partName);

    List<Tailor> getTailorByOrderNameBedNumPart(@Param("orderName")String orderName,@Param("bedNumber") int bedNumber,@Param("partName")String partName);

    List<Object> tailorReport(String orderName,int bedNumber);

    List<Object> tailorMonthReport(Date beginTime, Date endTime);

    List<CutQueryLeak> getTailorInfoByName(String orderName);

}
