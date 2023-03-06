package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("blogList", iBlogService.listAll());
        return "/list";
    }

    @GetMapping("/create-form")
    public String createForm(Model model){
        model.addAttribute("blog", new Blog());
        return "/create";
    }
    @PostMapping("/create")
    public String blogCreate(@ModelAttribute Blog blog, Model model){
        iBlogService.create(blog);
        return "redirect:/blog";
    }
    @GetMapping("/update-form/{id}")
    public  String updateForm(@PathVariable int id, Model model){
        model.addAttribute("blogs", iBlogService.findById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String blogUpdate(Blog blog){
        iBlogService.update(blog);
        return "redirect:/blog";
    }
    @GetMapping("/delete/{id}")
    public String delete(@RequestParam int deleteId){
        iBlogService.delete(deleteId);
        return "redirect:/blog";
    }
}
