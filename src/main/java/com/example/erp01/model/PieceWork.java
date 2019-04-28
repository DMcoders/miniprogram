package com.example.erp01.model;

import java.sql.Timestamp;

public class PieceWork implements Comparable<PieceWork>{

    private Integer pieceWorkID;

    private String employeeNumber;

    private String orderName;

    private Integer bedNumber;

    private String colorName;

    private Integer packageNumber;

    private Integer layerCount;

    private String procedureName;

    private Timestamp createTime;

    private Timestamp updateTime;

    public PieceWork(Integer pieceWorkID, String employeeNumber, String orderName, Integer bedNumber, String colorName, Integer packageNumber, Integer layerCount, String procedureName, Timestamp createTime, Timestamp updateTime) {
        this.pieceWorkID = pieceWorkID;
        this.employeeNumber = employeeNumber;
        this.orderName = orderName;
        this.bedNumber = bedNumber;
        this.colorName = colorName;
        this.packageNumber = packageNumber;
        this.layerCount = layerCount;
        this.procedureName = procedureName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PieceWork(String employeeNumber, String orderName, Integer bedNumber, String colorName, Integer packageNumber, Integer layerCount, String procedureName, Timestamp createTime, Timestamp updateTime) {
        this.employeeNumber = employeeNumber;
        this.orderName = orderName;
        this.bedNumber = bedNumber;
        this.colorName = colorName;
        this.packageNumber = packageNumber;
        this.layerCount = layerCount;
        this.procedureName = procedureName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PieceWork(String employeeNumber, String orderName, Integer bedNumber, String colorName, Integer packageNumber, Integer layerCount, String procedureName) {
        this.employeeNumber = employeeNumber;
        this.orderName = orderName;
        this.bedNumber = bedNumber;
        this.colorName = colorName;
        this.packageNumber = packageNumber;
        this.layerCount = layerCount;
        this.procedureName = procedureName;
    }

    public PieceWork() {
    }

    @Override
    public String toString() {
        return "PieceWork{" +
                "pieceWorkID=" + pieceWorkID +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", orderName='" + orderName + '\'' +
                ", bedNumber=" + bedNumber +
                ", colorName='" + colorName + '\'' +
                ", packageNumber=" + packageNumber +
                ", layerCount=" + layerCount +
                ", procedureName='" + procedureName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getPieceWorkID() {
        return pieceWorkID;
    }

    public void setPieceWorkID(Integer pieceWorkID) {
        this.pieceWorkID = pieceWorkID;
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

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
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

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public int compareTo(PieceWork o) {
        return this.getCreateTime().compareTo(o.getCreateTime());
    }
}
