package com.example.ex1.service;

import com.example.ex1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> getAll(String name ,Pageable pageable);
    Blog getByID(int id);

    void delete(int id);

    void save(Blog blog);


    Page<Blog> getBlogByCategory(Integer id ,Pageable pageable);
}