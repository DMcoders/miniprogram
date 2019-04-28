package com.example.erp01.model;

public class Inspection implements Comparable<Inspection>{

    private Integer inspectionID;

    private String employeeNumber;

    private String orderName;

    private Integer bedNumber;

    private Integer packageNumber;

    private Integer layerCount;

    private String wrongCode;

    private Integer wrongQuantity;

    public Inspection(Integer inspectionID, String employeeNumber, String orderName, Integer bedNumber, Integer packageNumber, Integer layerCount, String wrongCode, Integer wrongQuantity) {
        this.inspectionID = inspectionID;
        this.employeeNumber = employeeNumber;
        this.orderName = orderName;
        this.bedNumber = bedNumber;
        this.packageNumber = packageNumber;
        this.layerCount = layerCount;
        this.wrongCode = wrongCode;
        this.wrongQuantity = wrongQuantity;
    }

    public Inspection(String employeeNumber, String orderName, Integer bedNumber, Integer packageNumber, Integer layerCount, String wrongCode, Integer wrongQuantity) {
        this.employeeNumber = employeeNumber;
        this.orderName = orderName;
        this.bedNumber = bedNumber;
        this.packageNumber = packageNumber;
        this.layerCount = layerCount;
        this.wrongCode = wrongCode;
        this.wrongQuantity = wrongQuantity;
    }

    public Inspection() {
    }

    @Override
    public String toString() {
        return "Inspection{" +
                "inspectionID=" + inspectionID +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", orderName='" + orderName + '\'' +
                ", bedNumber=" + bedNumber +
                ", packageNumber=" + packageNumber +
                ", layerCount=" + layerCount +
                ", wrongCode='" + wrongCode + '\'' +
                ", wrongQuantity=" + wrongQuantity +
                '}';
    }

    public Integer getInspectionID() {
        return inspectionID;
    }

    public void setInspectionID(Integer inspectionID) {
        this.inspectionID = inspectionID;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Integer getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(Integer packageNumber) {
        this.packageNumber = packageNumber;
    }

    public Integer getLayerCount() {
        return layerCount;
    }

    public void setLayerCount(Integer layerCount) {
        this.layerCount = layerCount;
    }

    public String getWrongCode() {
        return wrongCode;
    }

    public void setWrongCode(String wrongCode) {
        this.wrongCode = wrongCode;
    }

    public Integer getWrongQuantity() {
        return wrongQuantity;
    }

    public void setWrongQuantity(Integer wrongQuantity) {
        this.wrongQuantity = wrongQuantity;
    }

    @Override
    public int compareTo(Inspection o) {
        return this.orderName.compareTo(o.orderName);
    }
}
