package com.example.ex2.service.impl;

import com.example.ex2.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public Double addition(double firstNumber, double secondNumber) {
        return firstNumber+secondNumber;
    }

    @Override
    public Double subtraction(double firstNumber, double secondNumber) {
        return firstNumber-secondNumber;
    }

    @Override
    public Double multiplication(double firstNumber, double secondNumber) {
        return firstNumber*secondNumber;
    }

    @Override
    public Double division(double firstNumber, double secondNumber) {
        return firstNumber/secondNumber;
    }
}
