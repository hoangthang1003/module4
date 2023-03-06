package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    List<Blog> listAll();

    void create(Blog blog);

    Blog findById(Integer id);

    void update(Blog blog);

    void delete(Integer id);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> searchTitle(String title,Pageable pageable);
}
