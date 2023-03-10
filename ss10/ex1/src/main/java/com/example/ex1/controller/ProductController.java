package com.example.ex1.controller;


import com.example.ex1.model.Cart;
import com.example.ex1.model.Product;
import com.example.ex1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

//    @GetMapping("/minus/{id}")
//    public String minusToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
//        Optional<Product> productOptional = productService.findById(id);
//        if (!productOptional.isPresent()) {
//            return "/error.404";
//        }
//        if (action.equals("show")) {
//            cart.minusProduct(productOptional.get());
//            return "redirect:/shopping-cart";
//        }
//        cart.minusProduct(productOptional.get());
//        return "redirect:/shop";
//    }
//
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model, @ModelAttribute Product product){
        model.addAttribute("product",productService.findById(id));
        return "/detail";
    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteToCart(@PathVariable long id,
//                               @ModelAttribute Cart cart,
//                               @RequestParam("action") String action) {
//        Optional<Product> productOptional = productService.findById(id);
//        if (!productOptional.isPresent()) {
//            return "/error.404";
//        }
//        if (action.equals("show")) {
//            cart.delete(productOptional.get());
//            return "redirect:/shopping-cart";
//        }
//        cart.addProduct(productOptional.get());
//        return "redirect:/shop";
//    }
//
//    @GetMapping("/pay/")
//    public String payToCart(@ModelAttribute Cart cart) {
//        cart.deleteAll();
//        return "redirect:/shopping-cart";
//    }
}