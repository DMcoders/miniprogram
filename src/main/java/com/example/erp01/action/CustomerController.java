package com.example.erp01.action;

import com.example.erp01.model.Customer;
import com.example.erp01.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//顾客信息相关操作

@Controller(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 进入顾客信息页面
     * @param model
     * @return
     */
    @RequestMapping("/customerStart")
    public String customerStart(Model model){
        model.addAttribute("bigMenuTag",4);
        model.addAttribute("menuTag",43);
        List<Customer>  customers = getAllCustomer();
        model.addAttribute("customers",customers);
        return "factoryMsg/customer";
    }

    @RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
    @ResponseBody
    public int addCustomer(Customer customer){
        int res = customerService.addCustomer(customer);
        return res;
    }

    @RequestMapping(value = "/deletecustomer", method = RequestMethod.POST)
    @ResponseBody
    public int deleteCustomer(@RequestParam("customerID")Integer customerID,
                                 ModelMap map){
        int res = customerService.deleteCustomer(customerID);
        return res;
    }

    @RequestMapping(value = "/getallcustomer", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getAllCustomer(){
        List<Customer> customerList = customerService.getAllCustomer();
        return customerList;
    }

    @RequestMapping(value = "/getcustomerbyname", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerByName(@RequestParam("customerName")String customerName){
        Customer customer = customerService.getCustomerByName(customerName);
        return customer;
    }

    /*
    * 测试未通过，返回结果为空
    *
    * */
    @RequestMapping(value = "/getcustomerbyid", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerByID(@RequestParam("customerID")Integer customerID){
        System.out.println(customerID);
        Customer customer = customerService.getCustomerByID(customerID);
        if(customer == null){
            System.out.println("结果为空！");
        }
        return customer;
    }

}
