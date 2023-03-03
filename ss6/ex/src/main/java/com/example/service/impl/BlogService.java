package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> listAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void create(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void update(Blog blog) {
        Blog blogs = findById(blog.getId());
        blogs.setTitle(blog.getTitle());
        blogs.setContent(blog.getContent());
        blogs.setAuthor(blog.getAuthor());
        iBlogRepository.save(blogs);
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }
}
