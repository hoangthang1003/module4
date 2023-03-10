package com.example.ex1.controller;

import com.example.ex1.model.Blog;
import com.example.ex1.service.IBlogService;
import com.example.ex1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    IBlogService service;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(required = false, defaultValue = "") String name,
                           @PageableDefault(size = 3) Pageable pageable) {
//        Page<Blog> blogs = name == null ? this.service.getAll(pageable) : this.service.searchBlog(name, pageable);
        if (name == null) {
            name = "";
        }
        Sort sort = Sort.by("id").descending();
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<Blog> blogPage = service.getAll(name, sortedPageable);
        model.addAttribute("blog", blogPage);
        model.addAttribute("freeText", name);

        List<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= blogPage.getTotalPages(); i++) {
            integers.add(i);
        }
        model.addAttribute("pages", integers);
        return "/list";
    }

    @GetMapping("/form-create")
    public String getCreateForm(Model model) {
        model.addAttribute("category", categoryService.getAllCategory());
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog) {
        service.save(blog);
        return "redirect:/blogs";
    }


    @GetMapping("{id}")
    public String getBlog(@PathVariable int id, Model model) {
        model.addAttribute("blog", service.getByID(id));
        return "/detail";
    }

    @GetMapping("/delete")
    public String getDelete(@RequestParam int deleteId) {
        service.delete(deleteId);
        return "redirect:/blogs";
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", categoryService.getAllCategory());
        model.addAttribute("blog", service.getByID(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String getUpdate(@ModelAttribute Blog blog, Model model) {
        service.save(blog);
        model.addAttribute("blog", blog);
        return "redirect:/blogs";
    }
}
