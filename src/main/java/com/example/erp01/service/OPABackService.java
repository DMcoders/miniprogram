package com.example.erp01.service;

import com.example.erp01.model.OPABack;
import com.example.erp01.model.OpaQueryLeak;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OPABackService {

    int addOPABack(List<OPABack> opaBackList);

    List<OPABack> getAllOPABack();

    List<String> opaBackQuery(String orderName,Integer bedNumber);

    List<OpaQueryLeak> getOPABackInfoByOrderBedPart(String orderName,Integer bedNumber,String partName);
}
