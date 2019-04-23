package com.example.erp01.mapper;

import com.example.erp01.model.CutQueryLeak;
import com.example.erp01.model.Tailor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
//@Repository
public interface TailorMapper {

    List<Tailor> generateTailorData(String jsonStr);

    int saveTailorData(List<Tailor> tailorList);

    List<Tailor> getAllTailorData();

    List<Tailor> getAllTailorDataByOrder(String orderName);

    //由订单号获取当前最大床号
    Integer getMaxBedNumber(String orderName);

    List<Tailor> getTailorByOrderNameBedNumSizeColorPart(@Param("orderName") String orderName, @Param("bedNumber") int bedNumber, @Param("sizeName") String sizeName, @Param("colorName") String colorName, @Param("partName") String partName);

    List<Tailor> getTailorByOrderNameBedNum(@Param("orderName") String orderName, @Param("bedNumber") int bedNumber);

    int getTailorCountByOrderNameBedNum(@Param("orderName") String orderName, @Param("bedNumber") int bedNumber);

    List<Integer> getBedNumbersByOrderName(@Param("orderName") String orderName);

    List<String> getSizeNamesByOrderName(@Param("orderName") String orderName);

    List<String> getPartNamesByOrderName(@Param("orderName") String orderName);

    Integer getTailorCountByOrderNameBedNumPart(@Param("orderName") String orderName, @Param("bedNumber") int bedNumber, @Param("partName") String partName);

    List<Tailor> getTailorByOrderNameBedNumPart(@Param("orderName") String orderName, @Param("bedNumber") int bedNumber, @Param("partName") String partName);

    List<Object> tailorReport(@Param("orderName") String orderName, @Param("bedNumber") int bedNumber);

    List<Object> tailorMonthReport(@Param("beginTime")Date beginTime, @Param("endTime")Date endTime);

    List<CutQueryLeak> getTailorInfoByName(@Param("orderName") String orderName);

}
