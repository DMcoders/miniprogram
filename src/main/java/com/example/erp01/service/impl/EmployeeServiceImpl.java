package com.example.erp01.service.impl;

import com.example.erp01.mapper.EmployeeMapper;
import com.example.erp01.model.Employee;
import com.example.erp01.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int addEmployee(Employee employee) {
        try{
            employeeMapper.addEmployee(employee);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteEmployee(Integer employeeID) {
        try{
            employeeMapper.deleteEmployee(employeeID);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public Employee getEmpByID(Integer employeeID) {
        Employee employee = null;
        try{
            employee = employeeMapper.getEmpByID(employeeID);
            return employee;
        }catch (Exception e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public int updateEmployee(Employee employee) {
        try{
            employeeMapper.updateEmployee(employee);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try{
            employeeList = employeeMapper.getAllEmployee();
            return employeeList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public String getEmpNameByEmpNum(String employeeNumber) {
        try{
            String empName = employeeMapper.getEmpNameByEmpNum(employeeNumber);
            return empName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getGroupNameByEmpNum(String employeeNumber) {
        try{
            String groupName = employeeMapper.getGroupNameByEmpNum(employeeNumber);
            return groupName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getEmployeeByGroup(String groupName) {
        List<Employee> employeeList = new ArrayList<>();
        try{
            employeeList = employeeMapper.getEmployeeByGroup(groupName);
            return employeeList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return employeeList;
    }
}
