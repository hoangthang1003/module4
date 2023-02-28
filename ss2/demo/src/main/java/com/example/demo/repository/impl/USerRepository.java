package com.example.demo.repository.impl;

import com.example.demo.model.Login;
import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;

import java.util.ArrayList;
import java.util.List;

public class USerRepository implements IUserRepository {
    private static List<User> userList;

    static {
        userList = new ArrayList<>();
        userList.add(new User("join", "join", "join@codegym.vn", "123456", 10));
        userList.add(new User("bill", "bill", "bill@codegym.vn", "123456", 15));
        userList.add(new User("mike", "mike", "mike@codegym.vn", "123456", 16));
    }

    @Override
    public User checkLogin(Login login) {
        for (User u : userList) {
            if (u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())) {
                return u;
            }
        }
        return null;
    }
}
