package com.example.erp01.model;

public class SampleInspection implements Comparable<SampleInspection>{

    private Integer sampleInspectionID;

    private String employeeNumber;

    private String orderName;

    private Integer bedNumber;

    private Integer packageNumber;

    private Integer layerCount;

    private String wrongCode;

    private Integer wrongQuantity;

    public SampleInspection(Integer sampleInspectionID, String employeeNumber, String orderName, Integer bedNumber, Integer packageNumber, Integer layerCount, String wrongCode, Integer wrongQuantity) {
        this.sampleInspectionID = sampleInspectionID;
        this.employeeNumber = employeeNumber;
        this.orderName = orderName;
        this.bedNumber = bedNumber;
        this.packageNumber = packageNumber;
        this.layerCount = layerCount;
        this.wrongCode = wrongCode;
        this.wrongQuantity = wrongQuantity;
    }

    public SampleInspection(String employeeNumber, String orderName, Integer bedNumber, Integer packageNumber, Integer layerCount, String wrongCode, Integer wrongQuantity) {
        this.employeeNumber = employeeNumber;
        this.orderName = orderName;
        this.bedNumber = bedNumber;
        this.packageNumber = packageNumber;
        this.layerCount = layerCount;
        this.wrongCode = wrongCode;
        this.wrongQuantity = wrongQuantity;
    }

    public SampleInspection() {
    }

    @Override
    public String toString() {
        return "SampleInspection{" +
                "sampleInspectionID=" + sampleInspectionID +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", orderName='" + orderName + '\'' +
                ", bedNumber=" + bedNumber +
                ", packageNumber=" + packageNumber +
                ", layerCount=" + layerCount +
                ", wrongCode='" + wrongCode + '\'' +
                ", wrongQuantity=" + wrongQuantity +
                '}';
    }

    public Integer getSampleInspectionID() {
        return sampleInspectionID;
    }

    public void setSampleInspectionID(Integer sampleInspectionID) {
        this.sampleInspectionID = sampleInspectionID;
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
    public int compareTo(SampleInspection o) {
        return this.orderName.compareTo(o.orderName);
    }
}
