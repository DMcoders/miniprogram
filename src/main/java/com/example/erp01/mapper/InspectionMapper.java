package com.example.erp01.mapper;

import com.example.erp01.model.Inspection;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface InspectionMapper {

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
