package com.example.erp01.service.impl;

import com.example.erp01.mapper.WrongMapper;
import com.example.erp01.model.Wrong;
import com.example.erp01.service.WrongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class WrongServiceImpl implements WrongService {

    @Autowired
    private WrongMapper wrongMapper;

    @Override
    public int addWrong(Wrong wrong) {
        try{
            wrongMapper.addWrong(wrong);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteWrong(Integer wrongCodeID) {
        try{
            wrongMapper.deleteWrong(wrongCodeID);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<Wrong> getAllWrong() {
        List<Wrong> wrongList = new ArrayList<>();
        try{
            wrongList = wrongMapper.getAllWrong();
            return wrongList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
