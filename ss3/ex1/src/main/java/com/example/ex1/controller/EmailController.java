package com.example.ex1.controller;

import com.example.ex1.model.Email;
import com.example.ex1.service.impl.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
    @PostMapping("/updateEmail")
    public String updateEmail(@ModelAttribute Email email, RedirectAttributes redirectAttributes){
        this.emailService.updateEmail(email);
        redirectAttributes.addAttribute("msg","Update success");
        return "redirect:/email";
    }
}
