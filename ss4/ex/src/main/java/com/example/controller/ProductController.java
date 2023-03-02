package com.example.controller;

import com.example.service.IProductService;
import com.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/list")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String showList(@RequestParam(required = false) String nameSearch, Model model) {
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("productList", iProductService.listProduct(nameSearch));
        return "/list";

    }

    @GetMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("products", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product products, Model model) {
        iProductService.create(products);
        return "redirect:/list";
    }

    @GetMapping("/edit-form/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editProduct(Product product) {
        iProductService.update(product);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("productss", iProductService.findById(id));
        return "/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@RequestParam int deleteId) {
        iProductService.delete(deleteId);
        return "redirect:/list";
    }
}