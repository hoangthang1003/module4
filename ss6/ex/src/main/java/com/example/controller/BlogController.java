package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(name = "title",required = false) String title,
                           @PageableDefault(size = 3)Pageable pageable
                           ){
        Page<Blog> blogPage = title == null
                ? this.iBlogService.findAll(pageable)
                : this.iBlogService.searchTitle(title,pageable);
        model.addAttribute("blogPage",blogPage);
        model.addAttribute("freeText",title);
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < blogPage.getTotalPages(); i++) {
            integers.add(i);
        }
        model.addAttribute("pages",integers);
        return "/list";
    }

    @GetMapping("/create-form")
    public String createForm(Model model){
        model.addAttribute("blog", new Blog());
        return "/create";
    }
    @PostMapping("/create")
    public String blogCreate(@ModelAttribute Blog blog){
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
    public String delete(@PathVariable int id){
        iBlogService.delete(id);
        return "redirect:/blog";
    }
    @GetMapping("/inform/{id}")
    public String getInform(@PathVariable Integer id, Model model) {
        model.addAttribute("blogInform", iBlogService.findById(id));
//
        return "/detail";
    }
}
