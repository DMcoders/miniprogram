package com.example.erp01.service.impl;

import com.example.erp01.mapper.OPABackMapper;
import com.example.erp01.model.OPABack;
import com.example.erp01.model.OpaQueryLeak;
import com.example.erp01.service.OPABackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OPABackServiceImpl implements OPABackService {

    @Autowired
    private OPABackMapper opaBackMapper;

    @Override
    public int addOPABack(List<OPABack> opaBackList) {
        try{
            opaBackMapper.addOPABack(opaBackList);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<OPABack> getAllOPABack() {
        List<OPABack> opaBackList = new ArrayList<>();
        try{
            opaBackList = opaBackMapper.getAllOPABack();
            return opaBackList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return opaBackList;
    }

    @Override
    public List<String> opaBackQuery(String orderName, Integer bedNumber) {
        List<String> tailorQcodeList = new ArrayList<>();
        try{
            tailorQcodeList = opaBackMapper.opaBackQuery(orderName, bedNumber);
            return tailorQcodeList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return tailorQcodeList;
    }

    @Override
    public List<OpaQueryLeak> getOPABackInfoByOrderBedPart(String orderName, Integer bedNumber, String partName) {
        List<OpaQueryLeak> opaBackInfoList = new ArrayList<>();
        try{
            opaBackInfoList = opaBackMapper.getOPABackInfoByOrderBedPart(orderName, bedNumber, partName);
            return opaBackInfoList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return opaBackInfoList;
    }
}
