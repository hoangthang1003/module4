package com.example.ex1.service;

import com.example.ex1.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();

    void create(Order order);

    Order findById(int id);

    Order findByCode(Long code);


    void delete(Order order);
}
