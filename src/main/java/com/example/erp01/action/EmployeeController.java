package com.example.erp01.action;


import com.example.erp01.model.Employee;
import com.example.erp01.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/addemployee",method = RequestMethod.POST)
    public int addEmployee(Employee employee){
        int res = employeeService.addEmployee(employee);
        return res;
    }

    @RequestMapping(value = "/deleteemployee",method = RequestMethod.POST)
    public int deleteEmployee(@RequestParam("employeeID") Integer employeeID){
        int res = employeeService.deleteEmployee(employeeID);
        return res;
    }

    @RequestMapping(value = "/getempbyid",method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmpByID(@RequestParam("employeeID")Integer employeeID){
        Employee employee = employeeService.getEmpByID(employeeID);
        return employee;
    }

    @RequestMapping(value = "/updateemployee",method = RequestMethod.POST)
    public int updateEmployee(Employee employee){
        int res = employeeService.updateEmployee(employee);
        return res;
    }

    @RequestMapping(value = "/getallemployee",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllEmployee(){
        Map<String, Object> map = new HashMap<>();
        List<Employee> employeeList = new ArrayList<>();
        employeeList = employeeService.getAllEmployee();
        map.put("employeeList",employeeList);
        return map;
    }

    @RequestMapping(value = "/getempnamebyempnum",method = RequestMethod.GET)
    @ResponseBody
    public String getEmpNameByEmpNum(@RequestParam("employeeNumber")String employeeNumber){
        String employeeName = employeeService.getEmpNameByEmpNum(employeeNumber);
        return employeeName;
    }

    @RequestMapping(value = "/getgroupnamebyempnum",method = RequestMethod.GET)
    @ResponseBody
    public String getGroupNameByEmpNum(@RequestParam("employeeNumber")String employeeNumber){
        String groupName = employeeService.getGroupNameByEmpNum(employeeNumber);
        return groupName;
    }

    @RequestMapping(value = "/getemployeebygroup",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmployeeByGroupName(@RequestParam("groupName")String groupName){
        Map<String, Object> map = new HashMap<>();
        List<Employee> employeeList = new ArrayList<>();
        employeeList = employeeService.getEmployeeByGroup(groupName);
        map.put("groupEmployeeList",employeeList);
        return map;
    }


    @RequestMapping(value = "/getemphint",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmpHint(@RequestParam("subEmployeeNumber")String subEmployeeNumber){
        Map<String,Object> map = new HashMap<>();
        List<String> empNumberList = employeeService.getEmpHint(subEmployeeNumber);
        map.put("employeeNumberList",empNumberList);
        return map;
    }
}
