package com.example.erp01.model;

public class Dispatch {

    private Integer dispatchID;

    private String employeeNumber;

    private String employeeName;

    private String groupName;

    private String orderName;

    private String procedureName;

    public Dispatch(Integer dispatchID, String employeeNumber, String employeeName, String groupName, String orderName, String procedureName) {
        this.dispatchID = dispatchID;
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.groupName = groupName;
        this.orderName = orderName;
        this.procedureName = procedureName;
    }

    public Dispatch(String employeeNumber, String employeeName, String groupName, String orderName, String procedureName) {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.groupName = groupName;
        this.orderName = orderName;
        this.procedureName = procedureName;
    }

    public Dispatch() {
    }

    @Override
    public String toString() {
        return "Dispatch{" +
                "dispatchID=" + dispatchID +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", orderName='" + orderName + '\'' +
                ", procedureName='" + procedureName + '\'' +
                '}';
    }

    public Integer getDispatchID() {
        return dispatchID;
    }

    public void setDispatchID(Integer dispatchID) {
        this.dispatchID = dispatchID;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }
}
