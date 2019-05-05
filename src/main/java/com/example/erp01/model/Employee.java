package com.example.erp01.model;

public class Employee {

    private Integer employeeID;

    private String employeeName;

    private String employeeNumber;

    private String passWord;

    private String groupName;

    private String identifyCard;

    private String bankCard;

    private String role;

    private String gender;

    private String phoneNumber;

    public Employee(Integer employeeID, String employeeName, String employeeNumber, String passWord, String groupName, String identifyCard, String bankCard, String role, String gender, String phoneNumber) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
        this.passWord = passWord;
        this.groupName = groupName;
        this.identifyCard = identifyCard;
        this.bankCard = bankCard;
        this.role = role;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public Employee(String employeeName, String employeeNumber, String passWord, String groupName, String identifyCard, String bankCard, String role, String phoneNumber) {
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
        this.passWord = passWord;
        this.groupName = groupName;
        this.identifyCard = identifyCard;
        this.bankCard = bankCard;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }

    public Employee(String employeeName, String employeeNumber, String passWord, String groupName, String identifyCard, String bankCard, String role, String gender, String phoneNumber) {
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
        this.passWord = passWord;
        this.groupName = groupName;
        this.identifyCard = identifyCard;
        this.bankCard = bankCard;
        this.role = role;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", passWord='" + passWord + '\'' +
                ", groupName='" + groupName + '\'' +
                ", identifyCard='" + identifyCard + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", role='" + role + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getIdentifyCard() {
        return identifyCard;
    }

    public void setIdentifyCard(String identifyCard) {
        this.identifyCard = identifyCard;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
