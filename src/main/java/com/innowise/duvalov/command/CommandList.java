package com.innowise.duvalov.command;

import com.innowise.duvalov.command.impl.AddNewUserCommand;
import com.innowise.duvalov.command.impl.CheckUserCommand;
import com.innowise.duvalov.command.impl.OpenSessionCommand;
import lombok.Getter;

public enum CommandList {
    SEND_USER(new AddNewUserCommand()),
    CHECK_USER(new CheckUserCommand()),
    OPEN_SESSION(new OpenSessionCommand());

    @Getter
    private Command command;

    CommandList(Command command) {
        this.command = command;
    }
}
