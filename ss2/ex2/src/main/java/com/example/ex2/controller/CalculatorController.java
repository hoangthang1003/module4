package com.example.ex2.controller;

import com.example.ex2.service.ICalculatorService;
import com.example.ex2.service.impl.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    private final ICalculatorService calculatorService = new CalculatorService();
    @GetMapping("")
    public String display() {
        return "/calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam double firstNumber, @RequestParam double secondNumber, @RequestParam String method, Model model) {
        double result = 0;
        switch (method) {
            case "addition":
                result = calculatorService.addition(firstNumber,secondNumber);
                break;
            case "subtraction":
                result = calculatorService.subtraction(firstNumber,secondNumber);
                break;
            case "multiplication":
                result = calculatorService.multiplication(firstNumber,secondNumber);
                break;
            case "division":

                result = calculatorService.division(firstNumber,secondNumber);
                break;
        }
        model.addAttribute("result", result);
        return "/calculator";
    }
}

