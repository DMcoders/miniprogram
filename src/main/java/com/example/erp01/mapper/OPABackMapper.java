package com.example.erp01.mapper;

import com.example.erp01.model.OPABack;
import com.example.erp01.model.OpaQueryLeak;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OPABackMapper {

    int addOPABack(List<OPABack> opaBackList);

    List<OPABack> getAllOPABack();

    List<String> opaBackQuery(@Param("orderName")String orderName,@Param("bedNumber") Integer bedNumber);

    List<OpaQueryLeak> getOPABackInfoByOrderBedPart(@Param("orderName") String orderName, @Param("bedNumber") Integer bedNumber, @Param("partName") String partName);

}
