package com.example.erp01.action;

import com.example.erp01.model.Inspection;
import com.example.erp01.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller(value = "/inspection")
public class InspectionController {

    @Autowired
    private InspectionService inspectionService;

    @RequestMapping(value = "/inspectionStart")
    public String inspectionStart(Model model){
        model.addAttribute("bigMenuTag",5);
        model.addAttribute("menuTag",56);
        return "miniProgram/inspection";
    }

    @RequestMapping(value = "/addinspection",method = RequestMethod.POST)
    public int addInspection(Inspection inspection){
        int res = inspectionService.addInspection(inspection);
        return res;
    }

    @RequestMapping(value = "/deleteinspection",method = RequestMethod.POST)
    public int deleteInspection(Integer inspectionID){
        int res = inspectionService.deleteInspection(inspectionID);
        return res;
    }

    @RequestMapping(value = "/getallinspection",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllInspection(){
        Map<String,Object> map = new HashMap<>();
        List<Inspection> inspectionList = inspectionService.getAllInspection();
        Collections.sort(inspectionList);
        map.put("allInspection",inspectionList);
        return map;
    }

    @RequestMapping(value = "/getinspectionbyorder",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getInspectionByOrder(@RequestParam("orderName")String orderName){
        Map<String,Object> map = new HashMap<>();
        List<Inspection> inspectionList = inspectionService.getInspectionByOrder(orderName);
        map.put("inspectionByOrder",inspectionList);
        return map;
    }
    @RequestMapping(value = "/getinspectionbyorderbed",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getInspectionByOrderBed(@RequestParam("orderName")String orderName,
                                                      @RequestParam("bedNumber")Integer bedNumber){
        Map<String,Object> map = new HashMap<>();
        List<Inspection> inspectionList = inspectionService.getInspectionByOrderBed(orderName, bedNumber);
        map.put("inspectionByOrderBed",inspectionList);
        return map;
    }

    @RequestMapping(value = "/getinspectionbyemporder",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getInspectionByEmpOrder(@RequestParam("employeeNumber")String employeeNumber,
                                                      @RequestParam("orderName")String orderName){
        Map<String,Object> map = new HashMap<>();
        List<Inspection> inspectionList = inspectionService.getInspectionByEmpOrder(employeeNumber, orderName);
        map.put("inspectionByEmpOrder",inspectionList);
        return map;
    }

    @RequestMapping(value = "/getinspectiontoday",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getInspectionToday(){
        Map<String,Object> map = new HashMap<>();
        List<Inspection> inspectionList = inspectionService.getInspectionToday();
        map.put("inspectionToday",inspectionList);
        return map;
    }

    @RequestMapping(value = "/getinspectionthismonth",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getInspectionThisMonth(){
        Map<String,Object> map = new HashMap<>();
        List<Inspection> inspectionList = inspectionService.getInspectionThisMonth();
        map.put("inspectionThisMonth",inspectionList);
        return map;
    }

    @RequestMapping(value = "/getinspectionemptoday",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getInspectionEmpToday(@RequestParam("employeeNumber")String employeeNumber){
        Map<String,Object> map = new HashMap<>();
        List<Inspection> inspectionList = inspectionService.getInspectionEmpToday(employeeNumber);
        map.put("inspectionEmpToday",inspectionList);
        return map;
    }

    @RequestMapping(value = "/getinspectionempthismonth",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getInspectionEmpThisMonth(@RequestParam("employeeNumber")String employeeNumber){
        Map<String,Object> map = new HashMap<>();
        List<Inspection> inspectionList = inspectionService.getInspectionEmpThisMonth(employeeNumber);
        map.put("inspectionEmpThisMonth",inspectionList);
        return map;
    }

    @RequestMapping(value = "/getinspectionsummary",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getInspectionSummary(){
        Map<String,Object> map = new HashMap<>();
        List<Object> inspectionList = inspectionService.getInspectionSummary();
        map.put("data",inspectionList);
        return map;
    }

}
