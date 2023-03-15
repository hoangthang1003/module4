package com.example.ex1.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

    @Aspect
    @Component
    public class Logger {
        @AfterThrowing(value = "execution(* com.example.ex1.controller.BookController.order(..))")
        public  void checkEx(){
            System.out.println("-------------------------------");
            System.out.println("Gặp lỗi");
        }

        @After(value = "execution(* com.example.ex1.controller.BookController.order(..))")
        public  void logOrderDone(){
            System.out.println("-------------------------------");
            System.out.println("Done");
        }
}