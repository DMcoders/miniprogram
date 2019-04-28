package com.example.erp01.service.impl;

import com.example.erp01.mapper.OrderProcedureMapper;
import com.example.erp01.model.OrderProcedure;
import com.example.erp01.service.OrderProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderProcedureServiceImpl implements OrderProcedureService {

    @Autowired
    private OrderProcedureMapper orderProcedureMapper;

    @Override
    public int addOrderProcedure(OrderProcedure orderProcedure) {
        try{
            orderProcedureMapper.addOrderProcedure(orderProcedure);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteOrderProcedure(Integer id) {
        try{
            orderProcedureMapper.deleteOrderProcedure(id);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public OrderProcedure getOrderProcedureByID(Integer id) {
        OrderProcedure orderProcedure = null;
        try{
            orderProcedure = orderProcedureMapper.getOrderProcedureByID(id);
            return orderProcedure;
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderProcedure;
    }

    @Override
    public List<OrderProcedure> getAllOrderProcedure() {
        List<OrderProcedure> orderProcedureList = new ArrayList<>();
        try{
            orderProcedureList = orderProcedureMapper.getAllOrderProcedure();
            return orderProcedureList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderProcedureList;
    }

    @Override
    public List<OrderProcedure> getOrderProcedureByName(String orderName) {
        List<OrderProcedure> orderProcedureList = new ArrayList<>();
        try{
            orderProcedureList = orderProcedureMapper.getOrderProcedureByName(orderName);
            return orderProcedureList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderProcedureList;
    }

    @Override
    public List<String> getProcedureNamesByOrder(String orderName) {
        List<String> procedureNames = new ArrayList<>();
        try{
            procedureNames = orderProcedureMapper.getProcedureNamesByOrder(orderName);
            return procedureNames;
        }catch (Exception e){
            e.printStackTrace();
        }
        return procedureNames;

    }

    @Override
    public float getPriceByOrderProcedure(String orderName, String procedureName) {
        try{
            float procedurePrice = orderProcedureMapper.getPriceByOrderProcedure(orderName, procedureName);
            return procedurePrice;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getTimeByOrderProcedure(String orderName, String procedureName) {
        try{
            int procedureTime = orderProcedureMapper.getTimeByOrderProcedure(orderName, procedureName);
            return procedureTime;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;

    }
}
