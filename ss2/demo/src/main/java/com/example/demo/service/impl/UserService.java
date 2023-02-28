package com.example.demo.service.impl;

import com.example.demo.model.Login;
import com.example.demo.model.User;
import com.example.demo.repository.impl.USerRepository;
import com.example.demo.service.IUserService;

public class UserService implements IUserService {
     static USerRepository userRepository = new USerRepository();
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
