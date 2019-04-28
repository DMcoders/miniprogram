package com.example.erp01.mapper;

import com.example.erp01.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    int addEmployee(Employee employee);

    int deleteEmployee(Integer employeeID);

    Employee getEmpByID(Integer employeeID);

    int updateEmployee(Employee employee);

    List<Employee> getAllEmployee();

    String getEmpNameByEmpNum(String employeeNumber);

    String getGroupNameByEmpNum(String employeeNumber);

    List<Employee> getEmployeeByGroup(String groupName);


}
