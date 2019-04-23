package com.example.erp01.service;

import com.example.erp01.model.OrderProcedure;

import java.util.List;

public interface OrderProcedureService {

    int addOrderProcedure(OrderProcedure orderProcedure);

    int deleteOrderProcedure(Integer id);

    OrderProcedure getOrderProcedureByID(Integer id);

    List<OrderProcedure> getAllOrderProcedure();

    List<OrderProcedure> getOrderProcedureByName(String orderName);

}
