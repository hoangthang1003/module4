package com.example.ex1.service;

import com.example.ex1.model.Product;

import java.util.List;
import java.util.Optional;



    public interface IProductService {
        Iterable<Product> findAll();
        Optional<Product> findById(Long id);
    }
