package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;


public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(long id);
    Customer findByName(String name);
    void create(Customer customer);

}
