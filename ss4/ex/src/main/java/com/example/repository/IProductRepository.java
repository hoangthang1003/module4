package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> listProduct(String nameSearch);

    void create(Product product);

    Product findById(int id);

    void update(Product product);

    void delete(int id);
}
