package com.example.demo333.command;

import com.example.demo333.command.impl.AddUserCommand;
import com.example.demo333.command.impl.DefaultCommand;
import com.example.demo333.command.impl.LoginCommand;
import com.example.demo333.command.impl.LogoutCommand;

public enum CommandType {
    ADD_USER(new AddUserCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    DEFAULT (new DefaultCommand());

    Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public static Command define(String strCommand){
        CommandType currentComType = CommandType.valueOf(strCommand);
        return currentComType.command;
    }
}
