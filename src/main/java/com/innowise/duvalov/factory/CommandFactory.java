package com.innowise.duvalov.factory;

import com.innowise.duvalov.command.Command;
import com.innowise.duvalov.command.CommandList;

public class CommandFactory {
    public Command getCommand(String commandName){
        return CommandList.valueOf(commandName).getCommand();
    }
}
