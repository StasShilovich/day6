package com.shilovich.day6.controller.command;

import com.shilovich.day6.controller.command.impl.EmptyCommand;

public class ActionFactory {
    public ActionCommand defineCommand(String command) {
        ActionCommand current = new EmptyCommand();
        if (command.isEmpty()) {
            return current;
        }
        CommandType currentEnum = CommandType.valueOf(command.toUpperCase());
        current = currentEnum.getCommand();
        return current;
    }
}
