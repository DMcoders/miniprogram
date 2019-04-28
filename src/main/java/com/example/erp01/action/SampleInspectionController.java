package com.example.erp01.action;

import com.example.erp01.model.SampleInspection;
import com.example.erp01.service.SampleInspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "/sampleinspection")
public class SampleInspectionController {

    @Autowired
    private SampleInspectionService sampleInspectionService;

    @RequestMapping(value = "/addsampleinspection",method = RequestMethod.POST)
    public int addInspection(SampleInspection sampleInspection){
        int res = sampleInspectionService.addSampleInspection(sampleInspection);
        return res;
    }

    @RequestMapping(value = "/deletesampleinspection",method = RequestMethod.POST)
    public int deleteSampleInspection(Integer sampleInspectionID){
        int res = sampleInspectionService.deleteSampleInspection(sampleInspectionID);
        return res;
    }

    @RequestMapping(value = "/getallsampleinspection",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllSampleInspection(){
        Map<String,Object> map = new HashMap<>();
        List<SampleInspection> sampleInspectionList = sampleInspectionService.getAllSampleInspection();
        map.put("allSampleInspection",sampleInspectionList);
        return map;
    }

    @RequestMapping(value = "/getsampleinspectionbyorder",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSampleInspectionByOrder(@RequestParam("orderName")String orderName){
        Map<String,Object> map = new HashMap<>();
        List<SampleInspection> sampleInspectionList = sampleInspectionService.getSampleInspectionByOrder(orderName);
        map.put("sampleInspectionByOrder",sampleInspectionList);
        return map;
    }
    @RequestMapping(value = "/getsampleinspectionbyorderbed",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSampleInspectionByOrderBed(@RequestParam("orderName")String orderName,
                                                      @RequestParam("bedNumber")Integer bedNumber){
        Map<String,Object> map = new HashMap<>();
        List<SampleInspection> sampleInspectionList = sampleInspectionService.getSampleInspectionByOrderBed(orderName, bedNumber);
        map.put("sampleInspectionByOrderBed",sampleInspectionList);
        return map;
    }

    @RequestMapping(value = "/getsampleinspectionbyemporder",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSampleInspectionByEmpOrder(@RequestParam("employeeNumber")String employeeNumber,
                                                      @RequestParam("orderName")String orderName){
        Map<String,Object> map = new HashMap<>();
        List<SampleInspection> sampleInspectionList = sampleInspectionService.getSampleInspectionByEmpOrder(employeeNumber, orderName);
        map.put("sampleInspectionByEmpOrder",sampleInspectionList);
        return map;
    }

    @RequestMapping(value = "/getsampleinspectiontoday",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSampleInspectionToday(){
        Map<String,Object> map = new HashMap<>();
        List<SampleInspection> sampleInspectionList = sampleInspectionService.getSampleInspectionToday();
        map.put("sampleInspectionToday",sampleInspectionList);
        return map;
    }

    @RequestMapping(value = "/getsampleinspectionthismonth",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSampleInspectionThisMonth(){
        Map<String,Object> map = new HashMap<>();
        List<SampleInspection> sampleInspectionList = sampleInspectionService.getSampleInspectionThisMonth();
        map.put("sampleInspectionThisMonth",sampleInspectionList);
        return map;
    }

    @RequestMapping(value = "/getsampleinspectionemptoday",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSampleInspectionEmpToday(@RequestParam("employeeNumber")String employeeNumber){
        Map<String,Object> map = new HashMap<>();
        List<SampleInspection> sampleInspectionList = sampleInspectionService.getSampleInspectionEmpToday(employeeNumber);
        map.put("sampleInspectionEmpToday",sampleInspectionList);
        return map;
    }

    @RequestMapping(value = "/getsampleinspectionempthismonth",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSampleInspectionEmpThisMonth(@RequestParam("employeeNumber")String employeeNumber){
        Map<String,Object> map = new HashMap<>();
        List<SampleInspection> sampleInspectionList = sampleInspectionService.getSampleInspectionEmpThisMonth(employeeNumber);
        map.put("sampleInspectionEmpThisMonth",sampleInspectionList);
        return map;
    }


}
