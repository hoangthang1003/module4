package com.example.demo.service;

import com.example.demo.model.Login;
import com.example.demo.model.User;

public interface IUserService {
    User checkLogin(Login login);

}
