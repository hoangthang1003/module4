package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("")
    String showList(Model model) {
        model.addAttribute("customerList",iCustomerService.findAll());
        return "/list";
    }

    @GetMapping("{id}")
    String showById(@PathVariable int id, Model model, @ModelAttribute Customer customer) {
        model.addAttribute("customer",iCustomerService.findById(id));
        return "detail";
    }

}
