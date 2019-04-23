package com.example.erp01.model;

public class Customer {


    private Integer customerID;

    private String customerName;

    private String companyName;

    private String linkmanName;

    private String linkmanPhone;

    private String companyAddress;


    public Customer() {
    }

    public Customer(String customerName, String companyName, String linkmanName, String linkmanPhone, String companyAddress) {
        this.customerName = customerName;
        this.companyName = companyName;
        this.linkmanName = linkmanName;
        this.linkmanPhone = linkmanPhone;
        this.companyAddress = companyAddress;

    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

}
