package com.example.erp01.service.impl;

import com.example.erp01.mapper.CustomerMapper;
import com.example.erp01.model.Customer;
import com.example.erp01.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public int addCustomer(Customer customer) {
        try{
            customerMapper.addCustomer(customer);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteCustomer(Integer customerID) {
        try{
            customerMapper.deleteCustomer(customerID);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = null;
        try{
            customerList = customerMapper.getAllCustomer();
            return customerList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer getCustomerByName(String customerName) {
        Customer customer = null;
        try{
            customer = customerMapper.getCustomerByName(customerName);
            return customer;
        }catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer getCustomerByID(Integer customerID) {
        Customer customer = null;
        try{
            customerMapper.getCustomerByID(customerID);
            return customer;
        }catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    }
}
