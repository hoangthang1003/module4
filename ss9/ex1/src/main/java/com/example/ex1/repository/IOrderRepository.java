package com.example.ex1.repository;

import com.example.ex1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Integer> {
    Order findOrderByCode(Long code);
}