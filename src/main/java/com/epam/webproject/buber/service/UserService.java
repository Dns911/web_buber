package com.epam.webproject.buber.service;

public interface UserService {
    boolean authenticate(String login, String password);
}
