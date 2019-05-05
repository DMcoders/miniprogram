package com.example.erp01.service;

import com.example.erp01.model.Inspection;

import java.util.Date;
import java.util.List;

public interface InspectionService {

    int addInspection(Inspection inspection);

    int deleteInspection(Integer inspectionID);

    List<Inspection> getAllInspection();

    List<Inspection> getInspectionByOrder(String orderName);

    List<Inspection> getInspectionByOrderBed(String orderName,Integer bedNumber);

    List<Inspection> getInspectionByEmpOrder(String orderName,String employeeNumber);

    List<Inspection> getInspectionToday();

    List<Inspection> getInspectionThisMonth();

    List<Inspection> getInspectionEmpToday(String employeeNumber);

    List<Inspection> getInspectionEmpThisMonth(String employeeNumber);

    List<Object> getInspectionSummary();

}
