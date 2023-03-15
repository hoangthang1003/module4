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
        IBlogRepository repository;

        @Override
        public Page<Blog> getAll(String name, Pageable pageable) {
            return repository.findBlogByNameContaining(name, pageable);
        }

        @Override
        public Blog getByID(int id) {
            return repository.findById(id).orElse(null);
        }

        @Override
        public List<Blog> findAll() {
            return repository.findAll();
        }

}