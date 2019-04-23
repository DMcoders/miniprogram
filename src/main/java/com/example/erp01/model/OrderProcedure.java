package com.example.erp01.model;

public class OrderProcedure implements Comparable<OrderProcedure>{

    private Integer orderProcedureID;

    private String orderName;

    private String procedureName;

    private float procedurePrice;

    private int procedureTime;

    public OrderProcedure(Integer orderProcedureID, String orderName, String procedureName, float procedurePrice, int procedureTime) {
        this.orderProcedureID = orderProcedureID;
        this.orderName = orderName;
        this.procedureName = procedureName;
        this.procedurePrice = procedurePrice;
        this.procedureTime = procedureTime;
    }

    public OrderProcedure(String orderName, String procedureName, float procedurePrice, int procedureTime) {
        this.orderName = orderName;
        this.procedureName = procedureName;
        this.procedurePrice = procedurePrice;
        this.procedureTime = procedureTime;
    }

    public OrderProcedure() {
    }

    public Integer getOrderProcedureID() {
        return orderProcedureID;
    }

    public void setOrderProcedureID(Integer orderProcedureID) {
        this.orderProcedureID = orderProcedureID;
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

    public float getProcedurePrice() {
        return procedurePrice;
    }

    public void setProcedurePrice(float procedurePrice) {
        this.procedurePrice = procedurePrice;
    }

    public int getProcedureTime() {
        return procedureTime;
    }

    public void setProcedureTime(int procedureTime) {
        this.procedureTime = procedureTime;
    }

    @Override
    public String toString() {
        return "OrderProcedure{" +
                "orderProcedureID=" + orderProcedureID +
                ", orderName='" + orderName + '\'' +
                ", procedureName='" + procedureName + '\'' +
                ", procedurePrice=" + procedurePrice +
                ", procedureTime=" + procedureTime +
                '}';
    }

    @Override
    public int compareTo(OrderProcedure o) {
        return this.getOrderName().compareTo(o.getOrderName());
    }
}
