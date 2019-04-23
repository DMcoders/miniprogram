package com.example.erp01.service.impl;

import com.example.erp01.mapper.OrderClothesMapper;
import com.example.erp01.model.CutQueryLeak;
import com.example.erp01.model.OrderClothes;
import com.example.erp01.service.OrderClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderClothesServiceImpl implements OrderClothesService {

    @Autowired
    private OrderClothesMapper orderClothesMapper;

    @Override
    public int addOrderClothes(List<OrderClothes> orderClothesList) {
        try{
            orderClothesMapper.addOrderClothes(orderClothesList);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<OrderClothes> getAllOrderClothes() {
        List<OrderClothes> orderClothesList = null;
        try{
            orderClothesList = orderClothesMapper.getAllOrderClothes();
            return orderClothesList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderClothesList;
    }

    @Override
    public List<OrderClothes> getOrderSummary() {
        List<OrderClothes> orderClothesList = new ArrayList<>();
        try {
            orderClothesList = orderClothesMapper.getOrderSummary();
            return orderClothesList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderClothesList;
    }

    @Override
    public List<OrderClothes> getOrderByName(String orderName) {
        List<OrderClothes> orderClothesList = null;
        try{
            orderClothesList = orderClothesMapper.getOrderByName(orderName);
            return orderClothesList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderClothesList;
    }

    @Override
    public int deleteOrderByName(String orderName) {
        try{
            orderClothesMapper.deleteOrderByName(orderName);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<String> getOrderHint(String subOrderName) {
        List<String> orderList = new ArrayList<>();
        try{
            orderList = orderClothesMapper.getOrderHint(subOrderName);
            return orderList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<String> getColorHint(String orderName) {
        List<String> colorList = new ArrayList<>();
        try{
            colorList = orderClothesMapper.getColorHint(orderName);
            return colorList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return colorList;
    }

    @Override
    public String getCustomerNameByOrderName(String orderName) {
        try{
            return orderClothesMapper.getCustomerNameByOrderName(orderName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CutQueryLeak> getOrderInfoByName(String orderName) {
        List<CutQueryLeak> orderInfoList = new ArrayList<>();
        try{
            orderInfoList = orderClothesMapper.getOrderInfoByName(orderName);
            return orderInfoList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderInfoList;
    }

}
