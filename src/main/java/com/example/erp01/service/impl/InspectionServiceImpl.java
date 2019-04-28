package com.example.erp01.service.impl;

import com.example.erp01.mapper.InspectionMapper;
import com.example.erp01.model.Inspection;
import com.example.erp01.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InspectionServiceImpl implements InspectionService {

    @Autowired
    private InspectionMapper inspectionMapper;

    @Override
    public int addInspection(Inspection inspection) {
        try{
            inspectionMapper.addInspection(inspection);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteInspection(Integer inspectionID) {
        try{
            inspectionMapper.deleteInspection(inspectionID);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<Inspection> getAllInspection() {
        List<Inspection> inspectionList = new ArrayList<>();
        try{
            inspectionList = inspectionMapper.getAllInspection();
            return inspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Inspection> getInspectionByOrder(String orderName) {
        List<Inspection> inspectionList = new ArrayList<>();
        try{
            inspectionList = inspectionMapper.getInspectionByOrder(orderName);
            return inspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Inspection> getInspectionByOrderBed(String orderName, Integer bedNumber) {
        List<Inspection> inspectionList = new ArrayList<>();
        try{
            inspectionList = inspectionMapper.getInspectionByOrderBed(orderName, bedNumber);
            return inspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Inspection> getInspectionByEmpOrder(String orderName, String employeeNumber) {
        List<Inspection> inspectionList = new ArrayList<>();
        try{
            inspectionList = inspectionMapper.getInspectionByEmpOrder(orderName, employeeNumber);
            return inspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Inspection> getInspectionToday() {
        List<Inspection> inspectionList = new ArrayList<>();
        try{
            inspectionList = inspectionMapper.getInspectionToday();
            return inspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Inspection> getInspectionThisMonth() {
        List<Inspection> inspectionList = new ArrayList<>();
        try{
            inspectionList = inspectionMapper.getInspectionThisMonth();
            return inspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Inspection> getInspectionEmpToday(String employeeNumber) {
        List<Inspection> inspectionList = new ArrayList<>();
        try{
            inspectionList = inspectionMapper.getInspectionEmpToday(employeeNumber);
            return inspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Inspection> getInspectionEmpThisMonth(String employeeNumber) {
        List<Inspection> inspectionList = new ArrayList<>();
        try{
            inspectionList = inspectionMapper.getInspectionEmpThisMonth(employeeNumber);
            return inspectionList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
