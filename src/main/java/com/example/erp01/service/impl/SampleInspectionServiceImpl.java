package com.example.erp01.service.impl;

import com.example.erp01.mapper.SampleInspectionMapper;
import com.example.erp01.model.SampleInspection;
import com.example.erp01.service.SampleInspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleInspectionServiceImpl implements SampleInspectionService {
    @Autowired
    private SampleInspectionMapper sampleInspectionMapper;

    @Override
    public int addSampleInspection(SampleInspection sampleInspection) {
        try{
            sampleInspectionMapper.addSampleInspection(sampleInspection);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteSampleInspection(Integer sampleInspectionID) {
        try{
            sampleInspectionMapper.deleteSampleInspection(sampleInspectionID);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<SampleInspection> getAllSampleInspection() {
        List<SampleInspection> sampleInspectionList = new ArrayList<>();
        try{
            sampleInspectionList = sampleInspectionMapper.getAllSampleInspection();
            return sampleInspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SampleInspection> getSampleInspectionByOrder(String orderName) {
        List<SampleInspection> sampleInspectionList = new ArrayList<>();
        try{
            sampleInspectionList = sampleInspectionMapper.getSampleInspectionByOrder(orderName);
            return sampleInspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SampleInspection> getSampleInspectionByOrderBed(String orderName, Integer bedNumber) {
        List<SampleInspection> sampleInspectionList = new ArrayList<>();
        try{
            sampleInspectionList = sampleInspectionMapper.getSampleInspectionByOrderBed(orderName, bedNumber);
            return sampleInspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SampleInspection> getSampleInspectionByEmpOrder(String orderName, String employeeNumber) {
        List<SampleInspection> sampleInspectionList = new ArrayList<>();
        try{
            sampleInspectionList = sampleInspectionMapper.getSampleInspectionByEmpOrder(orderName, employeeNumber);
            return sampleInspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SampleInspection> getSampleInspectionToday() {
        List<SampleInspection> sampleInspectionList = new ArrayList<>();
        try{
            sampleInspectionList = sampleInspectionMapper.getSampleInspectionToday();
            return sampleInspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SampleInspection> getSampleInspectionThisMonth() {
        List<SampleInspection> sampleInspectionList = new ArrayList<>();
        try{
            sampleInspectionList = sampleInspectionMapper.getSampleInspectionThisMonth();
            return sampleInspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SampleInspection> getSampleInspectionEmpToday(String employeeNumber) {
        List<SampleInspection> sampleInspectionList = new ArrayList<>();
        try{
            sampleInspectionList = sampleInspectionMapper.getSampleInspectionEmpToday(employeeNumber);
            return sampleInspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SampleInspection> getSampleInspectionEmpThisMonth(String employeeNumber) {
        List<SampleInspection> sampleInspectionList = new ArrayList<>();
        try{
            sampleInspectionList = sampleInspectionMapper.getSampleInspectionEmpThisMonth(employeeNumber);
            return sampleInspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> getSampleInspectionSummary() {
        List<Object> sampleInspectionList = new ArrayList<>();
        try{
            sampleInspectionList = sampleInspectionMapper.getSampleInspectionSummary();
            return sampleInspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
