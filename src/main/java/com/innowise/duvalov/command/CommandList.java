package com.innowise.duvalov.command;

import com.innowise.duvalov.command.impl.AddNewUserCommand;
import lombok.Getter;

public enum CommandList {
    SEND_USER(new AddNewUserCommand());

    @Getter
    private Command command;

    CommandList(Command command) {
        this.command = command;
    }
}
