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
@RequestMapping("/rest/blogs")
public class BlogRestController {
    @Autowired
    private BlogService iBlogService;

    @Autowired
    private CategoryService iCategoryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public String showList(Model model, @RequestParam(required = false, defaultValue = "") String name,
                           @PageableDefault(size = 3) Pageable pageable) {
        return this.iBlogService.getAll(name, pageable).toString();
    }



    @GetMapping("/category")
    @ResponseStatus(HttpStatus.OK)
    List<Category> findAll() {
        return this.iCategoryService.getAllCategory();
    }

    //    Xem danh sách các bài viết của một category

    @GetMapping("/category{id}")
    @ResponseStatus(HttpStatus.OK)
    public Set<Blog> getById(@PathVariable int id) {
        Category category = this.iCategoryService.getCategoryByID(id);
        return category.getBlogs();
    }
}
