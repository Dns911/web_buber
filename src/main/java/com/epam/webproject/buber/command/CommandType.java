package com.epam.webproject.buber.command;

import com.epam.webproject.buber.command.impl.AddUserCommand;
import com.epam.webproject.buber.command.impl.DefaultCommand;
import com.epam.webproject.buber.command.impl.LoginCommand;
import com.epam.webproject.buber.command.impl.LogoutCommand;

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
