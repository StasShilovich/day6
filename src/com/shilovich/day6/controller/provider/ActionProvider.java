package com.shilovich.day6.controller.provider;

import com.shilovich.day6.controller.command.ActionCommand;
import com.shilovich.day6.controller.command.type.CommandType;
import com.shilovich.day6.controller.command.impl.EmptyCommand;

public class ActionProvider {
    public ActionCommand defineCommand(String command) {
        ActionCommand current = new EmptyCommand();
        if (command.isEmpty()) {
            return current;
        }
        try {
            CommandType currentEnum = CommandType.valueOf(command.toUpperCase());
            current = currentEnum.getCommand();
        } catch (IllegalArgumentException e) {
            System.out.println("Command name is invalid: " + command);
        }
        return current;
    }
}
