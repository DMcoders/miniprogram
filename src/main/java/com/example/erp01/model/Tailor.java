package com.example.erp01.model;

public class Tailor {

    private Integer tailorID;

    private String orderName;

    private String customerName;

    private Integer bedNumber;

    private String jarName;

    private String colorName;

    private String sizeName;

    private String partName;

    private Integer layerCount;

    private Integer packageNumber;

    private Integer tailorReportCount;

    private String tailorQcode;

    public Tailor() {

    }

    public Tailor(String orderName, String customerName, Integer bedNumber, String jarName, String colorName, String sizeName, Integer layerCount) {
        this.orderName = orderName;
        this.customerName = customerName;
        this.bedNumber = bedNumber;
        this.jarName = jarName;
        this.colorName = colorName;
        this.sizeName = sizeName;
        this.layerCount = layerCount;
    }

    public Tailor(String orderName,String customerName,Integer bedNumber,String colorName,String sizeName,Integer layerCount){
        this.orderName = orderName;
        this.customerName = customerName;
        this.bedNumber = bedNumber;
        this.colorName = colorName;
        this.sizeName = sizeName;
        this.layerCount = layerCount;

    }

    public Tailor(String orderName, String customerName, Integer bedNumber, String jarName, String colorName, String sizeName, String partName, Integer layerCount, Integer packageNumber, String tailorQcode) {
        this.orderName = orderName;
        this.customerName = customerName;
        this.bedNumber = bedNumber;
        this.jarName = jarName;
        this.colorName = colorName;
        this.sizeName = sizeName;
        this.partName = partName;
        this.layerCount = layerCount;
        this.packageNumber = packageNumber;
        this.tailorQcode = tailorQcode;
    }

    public Tailor(Integer tailorID, String orderName, String customerName, Integer bedNumber, String jarName, String colorName, String sizeName, String partName, Integer layerCount, Integer packageNumber, String tailorQcode) {
        this.tailorID = tailorID;
        this.orderName = orderName;
        this.customerName = customerName;
        this.bedNumber = bedNumber;
        this.jarName = jarName;
        this.colorName = colorName;
        this.sizeName = sizeName;
        this.partName = partName;
        this.layerCount = layerCount;
        this.packageNumber = packageNumber;
        this.tailorQcode = tailorQcode;
    }

    public Integer getTailorID() {
        return tailorID;
    }

    public void setTailorID(Integer tailorID) {
        this.tailorID = tailorID;
    }

    public String getOrderName() {
        return orderName;
    }

    public Integer getTailorReportCount() {
        return tailorReportCount;
    }

    public void setTailorReportCount(Integer tailorReportCount) {
        this.tailorReportCount = tailorReportCount;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getTailorQcode() {
        return tailorQcode;
    }

    public void setTailorQcode(String tailorQcode) {
        this.tailorQcode = tailorQcode;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getJarName() {
        return jarName;
    }

    public void setJarName(String jarName) {
        this.jarName = jarName;
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

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Integer getLayerCount() {
        return layerCount;
    }

    public void setLayerCount(Integer layerCount) {
        this.layerCount = layerCount;
    }

    public Integer getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(Integer packageNumber) {
        this.packageNumber = packageNumber;
    }
}
