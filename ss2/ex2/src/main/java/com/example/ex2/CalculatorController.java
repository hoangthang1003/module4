package com.example.ex2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("")
    public String display() {
        return "/calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam double num1, @RequestParam double num2, @RequestParam String method, Model model) {
        double result = 0;
        switch (method) {
            case "addition":
                result = num1 + num2;
                break;
            case "subtraction":
                result = num1 - num2;
                break;
            case "multiplication":
                result = num1 * num2;
                break;
            case "division":

                result = num1 / num2;
                break;
        }
        model.addAttribute("result", result);
        return "/calculator";
    }
}

