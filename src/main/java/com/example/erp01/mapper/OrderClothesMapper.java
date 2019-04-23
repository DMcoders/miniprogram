package com.example.erp01.mapper;

import com.example.erp01.model.CutQueryLeak;
import com.example.erp01.model.OrderClothes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
//@Repository
public interface OrderClothesMapper {

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
    //获取订单信息用作裁床查漏报表
    List<CutQueryLeak> getOrderInfoByName(String orderName);


}
