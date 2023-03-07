package com.example.ex.controller;

import com.example.ex.model.User;
import com.example.ex.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("userList",iUserService.listAllUser());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("user",new User());
        return "/create";
    }

    @PostMapping("/create")
    public String createUser(User user) {
        iUserService.create(user);
        return "redirect:/list";

    }
}
