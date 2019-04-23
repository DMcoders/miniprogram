package com.example.erp01.service;


import com.example.erp01.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface CustomerService {

    int addCustomer(Customer customer);

    int deleteCustomer(Integer customerID);

    List<Customer> getAllCustomer();

    Customer getCustomerByName(String customerName);

    Customer getCustomerByID(Integer customerID);

}
