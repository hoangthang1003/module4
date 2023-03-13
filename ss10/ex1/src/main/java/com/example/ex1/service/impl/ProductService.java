package com.example.ex1.service.impl;

import com.example.ex1.model.Product;
import com.example.ex1.repository.IProductRepository;
import com.example.ex1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }


    @Override
    public Product findId(Long id) {
        return iProductRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        iProductRepository.deleteById(id);
    }
}
