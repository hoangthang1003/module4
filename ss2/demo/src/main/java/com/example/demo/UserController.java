package com.example.demo;

import com.example.demo.model.Login;
import com.example.demo.model.User;
import com.example.demo.service.impl.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    UserService userService = new UserService();
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/home","login",new Login());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login) {
        User user = userService.checkLogin(login);
        if(user == null){
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/user");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}
