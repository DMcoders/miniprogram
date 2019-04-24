package com.example.erp01.action;

import com.example.erp01.model.OrderProcedure;
import com.example.erp01.service.OrderProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller(value = "/orderprocedure")
public class OrderProcedureController {

    @Autowired
    private OrderProcedureService orderProcedureService;

    @RequestMapping("/orderProcedureStart")
    public String orderProcedureStart(Model model){
        model.addAttribute("bigMenuTag",5);
        model.addAttribute("menuTag",51);
        return "miniProgram/orderProcedure";
    }

    @RequestMapping(value = "/addorderprocedure", method = RequestMethod.POST)
    @ResponseBody
    public int addOrderProcedure(OrderProcedure orderProcedure){
        int res = orderProcedureService.addOrderProcedure(orderProcedure);
        return res;
    }

    @RequestMapping(value = "/deleteorderprocedure", method = RequestMethod.POST)
    @ResponseBody
    public int deleteOrderProcedure(@RequestParam("orderProcedureID")Integer orderProcedureID){
        int res = orderProcedureService.deleteOrderProcedure(orderProcedureID);
        return res;
    }

    @RequestMapping(value = "/getallorderprocedure", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllOrderProcedure(){
        Map<String, Object> map = new HashMap();
        List<OrderProcedure> orderProcedureList = new ArrayList<>();
        orderProcedureList = orderProcedureService.getAllOrderProcedure();
        Collections.sort(orderProcedureList);
        map.put("data",orderProcedureList);
        return map;
    }

    @RequestMapping(value = "/getorderprocedurebyname", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderProcedure> getOrderProcedureByName(@RequestParam("orderName")String orderName){
        List<OrderProcedure> orderProcedureList = orderProcedureService.getOrderProcedureByName(orderName);
        return orderProcedureList;
    }

    @RequestMapping(value = "/getorderprocedurebyid", method = RequestMethod.GET)
    @ResponseBody
    public OrderProcedure getOrderProcedureByID(@RequestParam("orderProcedureID")Integer orderProcedureID){
        OrderProcedure orderProcedure = orderProcedureService.getOrderProcedureByID(orderProcedureID);
        return orderProcedure;
    }

}
