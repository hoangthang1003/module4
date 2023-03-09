package com.example.ex1.service;

import com.example.ex1.model.Cart;

import java.util.List;

public interface ICartService {

    List<Cart> findAll();

    Cart findById(int id);

    void save(Cart cart);
}
