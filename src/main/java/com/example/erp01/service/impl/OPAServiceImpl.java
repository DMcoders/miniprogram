package com.example.erp01.service.impl;

import com.example.erp01.mapper.OPAMapper;
import com.example.erp01.model.OPA;
import com.example.erp01.service.OPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OPAServiceImpl implements OPAService {

    @Autowired
    private OPAMapper opaMapper;

    @Override
    public int addOPA(OPA opa) {
        try{
            opaMapper.addOPA(opa);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteOPA(Integer opaID) {
        try{
            opaMapper.deleteOPA(opaID);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<OPA> getAllOPA() {
        List<OPA> opaList = new ArrayList<>();
        try{
            opaList = opaMapper.getAllOPA();
            return opaList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return opaList;
    }
}
