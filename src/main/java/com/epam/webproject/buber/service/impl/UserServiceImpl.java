package com.example.demo333.service.impl;

import com.example.demo333.service.UserService;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean authenticate(String login, String password) {
        return login.equals(password); //todo
    }
}
