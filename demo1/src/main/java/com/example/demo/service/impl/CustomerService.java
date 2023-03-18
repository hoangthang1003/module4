package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public Customer findByName(String name) {
        return iCustomerRepository.findByName(name);
    }

    @Override
    public void create(Customer customer) {
        iCustomerRepository.save(customer);
    }
}
