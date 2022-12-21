package com.epam.webproject.buber.dao;

public interface UserDao {
    boolean authenticate(String login, String password);
}
