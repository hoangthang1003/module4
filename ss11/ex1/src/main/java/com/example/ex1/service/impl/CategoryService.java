package com.example.ex1.service.impl;

import com.example.ex1.model.Category;
import com.example.ex1.repository.ICategoryRepository;
import com.example.ex1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category getCategoryByID(int id) {
        return iCategoryRepository.findById(id).get();
    }

    @Override
    public void deleteCategory(int id) {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public void saveCategory(Category category) {
        iCategoryRepository.save(category);
    }
}
