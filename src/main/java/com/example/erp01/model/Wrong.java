package com.example.erp01.model;

public class Wrong implements Comparable<Wrong> {

    private Integer wrongCodeID;

    private String wrongCode;

    private String wrongDescription;

    private String orderName;

    public Wrong(String wrongCode, String wrongDescription, String orderName) {
        this.wrongCode = wrongCode;
        this.wrongDescription = wrongDescription;
        this.orderName = orderName;
    }

    public Wrong(Integer wrongCodeID, String wrongCode, String wrongDescription, String orderName) {
        this.wrongCodeID = wrongCodeID;
        this.wrongCode = wrongCode;
        this.wrongDescription = wrongDescription;
        this.orderName = orderName;
    }

    public Wrong() {
    }

    @Override
    public String toString() {
        return "Wrong{" +
                "wrongCodeID=" + wrongCodeID +
                ", wrongCode='" + wrongCode + '\'' +
                ", wrongDescription='" + wrongDescription + '\'' +
                ", orderName='" + orderName + '\'' +
                '}';
    }

    public Integer getWrongCodeID() {
        return wrongCodeID;
    }

    public void setWrongCodeID(Integer wrongCodeID) {
        this.wrongCodeID = wrongCodeID;
    }

    public String getWrongCode() {
        return wrongCode;
    }

    public void setWrongCode(String wrongCode) {
        this.wrongCode = wrongCode;
    }

    public String getWrongDescription() {
        return wrongDescription;
    }

    public void setWrongDescription(String wrongDescription) {
        this.wrongDescription = wrongDescription;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }


    @Override
    public int compareTo(Wrong o) {
        return this.orderName.compareTo(o.orderName);
    }
}
