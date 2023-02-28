package com.example.demo.repository;

import com.example.demo.model.Login;
import com.example.demo.model.User;

public interface IUserRepository {
    User checkLogin(Login login);
}
