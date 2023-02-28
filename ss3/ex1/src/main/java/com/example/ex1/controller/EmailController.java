package com.example.ex1.controller;

import com.example.ex1.service.impl.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Arrays;

@Controller
public class EmailController {
    EmailService emailService = new EmailService();
    @GetMapping("/email")
    public String display(Model model) {
        model.addAttribute("email",emailService.email());
        return "/email";
    }
    @GetMapping("/updateForm")
    public String updateForm(Model model){
        model.addAttribute("email", emailService.email());
        model.addAttribute("language", emailService.languagesList());
        model.addAttribute("pageSize", emailService.pageSize());
        return "/update";

    }
}
