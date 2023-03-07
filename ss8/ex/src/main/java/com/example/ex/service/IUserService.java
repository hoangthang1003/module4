package com.example.ex.service;

import com.example.ex.model.User;

import java.util.List;

public interface IUserService {
    List<User> listAllUser();

    void create(User user);
}
