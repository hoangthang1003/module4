package com.example.ex1.service.impl;


import com.example.ex1.model.Blog;
import com.example.ex1.repository.IBlogRepository;
import com.example.ex1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository repository;

    @Override
    public Page<Blog> getAll(String name,Pageable pageable) {
        return repository.findBlogByNameContaining(name, (java.awt.print.Pageable) pageable);
    }

    @Override
    public Blog getByID(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Page<Blog> getBlogByCategory(Integer id, Pageable pageable) {
        return repository.findBlogByCategory_Id(id, (java.awt.print.Pageable) pageable);
    }

}