package com.example.ex1.service;

import com.example.ex1.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategory();
    Category getCategoryByID(int id);

    void deleteCategory(int id);

    void saveCategory(Category category);
}