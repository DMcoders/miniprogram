package com.example.erp01.mapper;

import com.example.erp01.model.SampleInspection;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface SampleInspectionMapper {

    int addSampleInspection(SampleInspection sampleInspection);

    int deleteSampleInspection(Integer sampleInspectionID);

    List<SampleInspection> getAllSampleInspection();

    List<SampleInspection> getSampleInspectionByOrder(String orderName);

    List<SampleInspection> getSampleInspectionByOrderBed(String orderName,Integer bedNumber);

    List<SampleInspection> getSampleInspectionByEmpOrder(String orderName,String employeeNumber);

    List<SampleInspection> getSampleInspectionToday();

    List<SampleInspection> getSampleInspectionThisMonth();

    List<SampleInspection> getSampleInspectionEmpToday(String employeeNumber);

    List<SampleInspection> getSampleInspectionEmpThisMonth(String employeeNumber);

    List<Object> getSampleInspectionSummary();

}
