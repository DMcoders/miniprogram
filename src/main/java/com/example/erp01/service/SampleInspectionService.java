package com.example.erp01.service;

import com.example.erp01.model.SampleInspection;

import java.util.Date;
import java.util.List;

public interface SampleInspectionService {

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

}
