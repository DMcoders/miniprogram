package com.example.erp01.service;

import com.example.erp01.model.CutQueryLeak;
import com.example.erp01.model.OrderClothes;

import java.util.Date;
import java.util.List;

public interface OrderClothesService {

    int addOrderClothes(List<OrderClothes> orderClothesList);

    List<OrderClothes> getAllOrderClothes();

    List<OrderClothes> getOrderSummary();

    List<OrderClothes> getOrderByName(String orderName);

    int deleteOrderByName(String orderName);

    //订单输入下拉提示
    List<String> getOrderHint(String subOrderName);

    //颜色下拉提示
    List<String> getColorHint(String orderName);

    //输入订单自动带出顾客名
    String getCustomerNameByOrderName(String orderName);

    List<CutQueryLeak> getOrderInfoByName(String orderName);


}
