package com.epam.webproject.buber.service.impl;

import com.epam.webproject.buber.dao.impl.UserDaoImpl;
import com.epam.webproject.buber.service.UserService;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }


    @Override
    public boolean authenticate(String login, String password) {
        //
        //todo
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        boolean match = userDao.authenticate(login, password);
        return match;
    }
}
