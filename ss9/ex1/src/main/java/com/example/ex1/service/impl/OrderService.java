package com.example.ex1.service.impl;

import com.example.ex1.model.Order;
import com.example.ex1.repository.IOrderRepository;
import com.example.ex1.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;


    @Override
    public List<Order> findAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public void create(Order order) {
        iOrderRepository.save(order);
    }

    @Override
    public Order findById(int id) {
        return iOrderRepository.findById(id).get();
    }

    @Override
    public Order findByCode(Long code) {
        return iOrderRepository.findOrderByCode(code);
    }

    @Override
    public void delete(Order order) {
        iOrderRepository.delete(order);
    }
}
