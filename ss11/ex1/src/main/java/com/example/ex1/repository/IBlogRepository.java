package com.example.ex1.repository;

import com.example.ex1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findBlogByNameContaining(String name, Pageable pageable);

    Page<Blog> findBlogByCategory_Id(Integer id, Pageable pageable);
}