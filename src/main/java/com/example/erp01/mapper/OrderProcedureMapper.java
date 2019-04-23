package com.example.erp01.mapper;

import com.example.erp01.model.OrderProcedure;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderProcedureMapper {

    int addOrderProcedure(OrderProcedure orderProcedure);

    int deleteOrderProcedure(Integer id);

    OrderProcedure getOrderProcedureByID(Integer id);

    List<OrderProcedure> getAllOrderProcedure();

    List<OrderProcedure> getOrderProcedureByName(String orderName);

}
