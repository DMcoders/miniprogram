package com.example.erp01.service;

import com.example.erp01.model.Employee;

import java.util.List;

public interface EmployeeService {

    int addEmployee(Employee employee);

    int deleteEmployee(Integer employeeID);

    Employee getEmpByID(Integer employeeID);

    int updateEmployee(Employee employee);

    List<Employee> getAllEmployee();

    String getEmpNameByEmpNum(String employeeNumber);

    String getGroupNameByEmpNum(String employeeNumber);

    List<Employee> getEmployeeByGroup(String groupName);

}
