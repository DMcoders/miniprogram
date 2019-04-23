package com.example.erp01.service.impl;

import com.example.erp01.mapper.TailorMapper;
import com.example.erp01.model.CutQueryLeak;
import com.example.erp01.model.Tailor;
import com.example.erp01.service.TailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TailorServiceImpl implements TailorService {

    @Autowired
    private TailorMapper tailorMapper;

    @Override
    public List<Tailor> generateTailorData(String jsonStr) {
        List<Tailor> tailorList = null;
        try{
            tailorList = tailorMapper.generateTailorData(jsonStr);
            return tailorList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return tailorList;
    }

    @Override
    public int saveTailorData(List<Tailor> tailorList) {
        try{
            tailorMapper.saveTailorData(tailorList);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<Tailor> getAllTailorData(){
        List<Tailor> tailorList = null;
        try{
            tailorList = tailorMapper.getAllTailorData();
            return tailorList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return tailorList;
    }

    @Override
    public List<Tailor> getAllTailorDataByOrder(String orderName) {
        List<Tailor> tailorList = null;
        try{
            tailorList = tailorMapper.getAllTailorDataByOrder(orderName);
            return tailorList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return tailorList;
    }

    @Override
    public Integer getMaxBedNumber(String orderName) {
        try{
            Integer bedNumber = tailorMapper.getMaxBedNumber(orderName);
            return bedNumber;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tailor> getTailorByOrderNameBedNum(String orderName, int bedNumber) {
        List<Tailor> tailorList = new ArrayList<>();

        try{
            tailorList = tailorMapper.getTailorByOrderNameBedNum(orderName,bedNumber);
            return tailorList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return tailorList;
    }

    @Override
    public List<Tailor> getTailorByOrderNameBedNumSizeColorPart(String orderName, int bedNumber, String sizeName, String colorName,String partName) {
        List<Tailor> tailorList = new ArrayList<>();
        try{
            tailorList = tailorMapper.getTailorByOrderNameBedNumSizeColorPart(orderName, bedNumber, sizeName, colorName,partName);
            return tailorList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return tailorList;
    }



    @Override
    public int getTailorCountByOrderNameBedNum(String orderName, int bedNumber) {
        try {
            int tailorCount =  tailorMapper.getTailorCountByOrderNameBedNum(orderName, bedNumber);
            return tailorCount;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Integer> getBedNumbersByOrderName(String orderName) {
        List<Integer> bedNumList = new ArrayList<>();
        try{
            bedNumList = tailorMapper.getBedNumbersByOrderName(orderName);
            return bedNumList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return bedNumList;
    }

    @Override
    public List<String> getSizeNamesByOrderName(String orderName) {
        List<String> sizeNameList = new ArrayList<>();

        try{
            sizeNameList = tailorMapper.getSizeNamesByOrderName(orderName);
            return sizeNameList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return sizeNameList;
    }

    @Override
    public List<String> getPartNamesByOrderName(String orderName) {
        List<String> partNameList = new ArrayList<>();

        try{
            partNameList = tailorMapper.getPartNamesByOrderName(orderName);
            return partNameList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return partNameList;
    }

    @Override
    public Integer getTailorCountByOrderNameBedNumPart(String orderName, int bedNumber, String partName) {
        try{
            int tmpCount = tailorMapper.getTailorCountByOrderNameBedNumPart(orderName, bedNumber, partName);
            return tmpCount;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Tailor> getTailorByOrderNameBedNumPart(String orderName, int bedNumber, String partName) {
        List<Tailor> tailorList = new ArrayList<>();

        try{
            tailorList = tailorMapper.getTailorByOrderNameBedNumPart(orderName, bedNumber, partName);
            return tailorList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return tailorList;
    }

    @Override
    public List<Object> tailorReport(String orderName, int bedNumber) {
        List<Object> reportList = new ArrayList<>();
        try{
            reportList = tailorMapper.tailorReport(orderName, bedNumber);
            return reportList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> tailorMonthReport(Date beginTime, Date endTime) {
        List<Object> reportList = new ArrayList<>();
        try{
            reportList = tailorMapper.tailorMonthReport(beginTime, endTime);
            return reportList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CutQueryLeak> getTailorInfoByName(String orderName) {
        List<CutQueryLeak> tailorInfoList = new ArrayList<>();
        try{
            tailorInfoList = tailorMapper.getTailorInfoByName(orderName);
            return tailorInfoList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return tailorInfoList;
    }

}
