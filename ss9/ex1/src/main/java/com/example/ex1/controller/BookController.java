package com.example.ex1.controller;


import com.example.ex1.model.Book;
import com.example.ex1.model.Order;
import com.example.ex1.service.IBookService;
import com.example.ex1.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;
    @Autowired
    private IOrderService iOrderService;

    @GetMapping("")
    String showList(Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        return "list";
    }

    @GetMapping("/{id}")
    String showById(@PathVariable int id, Model model, @ModelAttribute Book book) {
        model.addAttribute("book", iBookService.findById(id));
        return "detail";
    }

    @GetMapping("/order/{id}")
    String order(@PathVariable int id, Model model) throws Exception {

        Book book = iBookService.findById(id);
        if (book.getQuantity() == 0) {
            throw new Exception();
        }
        book.setQuantity(book.getQuantity() - 1);
        Order order = new Order();
        long code = (long) (Math.random() * (99999 - 10000) + 10000);
        order.setCode(code);
        long millis = System.currentTimeMillis();
        order.setDate(new java.sql.Date(millis));
        List<Order> orders = book.getOrderList();
        orders.add(order);
        book.setOrderList(orders);

        iBookService.create(book);

        return "redirect:/books";
    }



    @PostMapping("/back/{code}")
    String giveBack(@PathVariable Long code, Model model) {
        Order order = iOrderService.findByCode(code);
        Book book1 = iBookService.findById(order.getId());
        book1.setQuantity(book1.getQuantity() + 1);
        iBookService.create(book1);
        iOrderService.delete(order);
        return "redirect:/books";
    }
}
