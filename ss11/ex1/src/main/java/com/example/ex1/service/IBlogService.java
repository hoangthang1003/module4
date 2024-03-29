package com.example.ex1.service;

import com.example.ex1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> getAll(String name, Pageable pageable);

    Blog getByID(int id);

    List<Blog> findAll();}