package com.example.ex1.service.impl;

import com.example.ex1.model.Cart;
import com.example.ex1.repository.ICartRepository;
import com.example.ex1.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    ICartRepository iCartRepository;

    @Override
    public List<Cart> findAll() {
        return iCartRepository.findAll();
    }

    @Override
    public Cart findById(int id) {
        return iCartRepository.findById(id).get();
    }

    @Override
    public void save(Cart cart) {
        iCartRepository.save(cart);
    }
}