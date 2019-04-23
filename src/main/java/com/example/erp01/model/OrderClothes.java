package com.example.erp01.model;

import java.util.Date;

public class OrderClothes {

    private Integer orderClothesID;

    private String customerName;

    private String purchaseMethod;

    private String orderName;

    private String styleDescription;

    private String clothesVersionNumber;

    private String colorNumber;

    private String colorName;

    private String sizeName;

    private Integer count;

    private Date orderDate;

    private String season;

    private Date deadLine;

    private Integer orderSum;

    public Integer getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(Integer orderSum) {
        this.orderSum = orderSum;
    }

    public OrderClothes(String customerName, String orderName, Integer orderSum, Date orderDate, String season, Date deadLine) {
        this.customerName = customerName;
        this.orderName = orderName;
        this.orderDate = orderDate;
        this.season = season;
        this.deadLine = deadLine;
        this.orderSum = orderSum;
    }

    public OrderClothes(Integer orderClothesID, String customerName, String purchaseMethod, String orderName, String styleDescription, String clothesVersionNumber, String colorNumber, String colorName, String sizeName, Integer count, Date orderDate, String season, Date deadLine) {
        this.orderClothesID = orderClothesID;
        this.customerName = customerName;
        this.purchaseMethod = purchaseMethod;
        this.orderName = orderName;
        this.styleDescription = styleDescription;
        this.clothesVersionNumber = clothesVersionNumber;
        this.colorNumber = colorNumber;
        this.colorName = colorName;
        this.sizeName = sizeName;
        this.count = count;
        this.orderDate = orderDate;
        this.season = season;
        this.deadLine = deadLine;
    }

    public OrderClothes(String customerName, String purchaseMethod, String orderName, String styleDescription, String clothesVersionNumber, String colorNumber, String colorName, String sizeName, Integer count, Date orderDate, String season, Date deadLine) {
        this.customerName = customerName;
        this.purchaseMethod = purchaseMethod;
        this.orderName = orderName;
        this.styleDescription = styleDescription;
        this.clothesVersionNumber = clothesVersionNumber;
        this.colorNumber = colorNumber;
        this.colorName = colorName;
        this.sizeName = sizeName;
        this.count = count;
        this.orderDate = orderDate;
        this.season = season;
        this.deadLine = deadLine;
    }

    public OrderClothes() {
    }

    public Integer getOrderClothesID() {
        return orderClothesID;
    }

    public void setOrderClothesID(Integer orderClothesID) {
        this.orderClothesID = orderClothesID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPurchaseMethod() {
        return purchaseMethod;
    }

    public void setPurchaseMethod(String purchaseMethod) {
        this.purchaseMethod = purchaseMethod;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getStyleDescription() {
        return styleDescription;
    }

    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription;
    }

    public String getClothesVersionNumber() {
        return clothesVersionNumber;
    }

    public void setClothesVersionNumber(String clothesVersionNumber) {
        this.clothesVersionNumber = clothesVersionNumber;
    }

    public String getColorNumber() {
        return colorNumber;
    }

    public void setColorNumber(String colorNumber) {
        this.colorNumber = colorNumber;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }
}
