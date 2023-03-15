package com.example.ex1.controller;

import com.example.ex1.model.Blog;
import com.example.ex1.model.Category;
import com.example.ex1.service.IBlogService;
import com.example.ex1.service.ICategoryService;
import com.example.ex1.service.impl.BlogService;
import com.example.ex1.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogRestController {
    //    Xem danh sách các bài viết
    @Autowired
    private IBlogService blogService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<Blog> getAll(
            @RequestParam(name = "name",required = false,defaultValue = "") String name,
            @PageableDefault(size = 3)Pageable pageable){
        return this.blogService.getAll(name, pageable);

    }

    //    Xem chi tiết một bài viết
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Blog findById(@PathVariable int id){
        return this.blogService.getByID(id);
    }
}
