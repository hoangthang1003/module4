package com.example.ex1.repository;

import com.example.ex1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    Page<Blog> findBlogByNameContaining(String name, Pageable pageable);


}