package com.example.erp01.model;

import java.util.Date;

public class OPA {

    private Integer opaID;

    private String orderName;

    private String customerName;

    private String destination;

    private Integer bedNumber;

    private String partName;

    private Integer opaCount;

    private Date opaDate;

    public OPA(Integer opaID, String orderName, String customerName, String destination, Integer bedNumber, String partName, Integer opaCount, Date opaDate) {
        this.opaID = opaID;
        this.orderName = orderName;
        this.customerName = customerName;
        this.destination = destination;
        this.bedNumber = bedNumber;
        this.partName = partName;
        this.opaCount = opaCount;
        this.opaDate = opaDate;
    }

    public OPA(String orderName, String customerName, String destination, Integer bedNumber, String partName, Date opaDate) {
        this.orderName = orderName;
        this.customerName = customerName;
        this.destination = destination;
        this.bedNumber = bedNumber;
        this.partName = partName;
        this.opaDate = opaDate;
    }

    public OPA(String orderName, String customerName, String destination, Integer bedNumber, String partName, Integer opaCount, Date opaDate) {
        this.orderName = orderName;
        this.customerName = customerName;
        this.destination = destination;
        this.bedNumber = bedNumber;
        this.partName = partName;
        this.opaCount = opaCount;
        this.opaDate = opaDate;
    }

    public OPA() {
    }

    public Integer getOpaID() {
        return opaID;
    }

    public void setOpaID(Integer opaID) {
        this.opaID = opaID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Integer getOpaCount() {
        return opaCount;
    }

    public void setOpaCount(Integer opaCount) {
        this.opaCount = opaCount;
    }

    public Date getOpaDate() {
        return opaDate;
    }

    public void setOpaDate(Date opaDate) {
        this.opaDate = opaDate;
    }
}
