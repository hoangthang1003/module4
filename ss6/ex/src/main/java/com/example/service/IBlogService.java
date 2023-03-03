package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> listAll();

    void create(Blog blog);

    Blog findById(Integer id);

    void update(Blog blog);

    void delete(Integer id);
}
