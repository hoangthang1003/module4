package com.example.ex.controller;

import com.example.ex.model.User;
import com.example.ex.dto.UserDTO;
import com.example.ex.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("")
    public String findAll(Model model){
        model.addAttribute("userList",iUserService.listAllUser());
        return "/list";
    }
    @GetMapping("create-form")
    public String createForm(Model model){
        model.addAttribute("userDto",new UserDTO());
        return "/create";
    }
    @PostMapping("create")
    public String create(@Validated @ModelAttribute UserDTO userDto, BindingResult bindingResult){
//        new UserDTO().validate(userDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        iUserService.create(user);
        return "redirect:/user";
    }
}
