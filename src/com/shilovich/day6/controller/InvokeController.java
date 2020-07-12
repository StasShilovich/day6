package com.shilovich.day6.controller;

import com.shilovich.day6.controller.command.ActionCommand;
import com.shilovich.day6.controller.command.ActionFactory;

import java.util.Map;

public class InvokeController {
    private static InvokeController instance;

    private InvokeController() {
    }

    public static InvokeController getInstance() {
        if (instance == null) {
            return new InvokeController();
        }
        return instance;
    }

    public Map processRequest(String command, Map<String, String> params) {
        ActionFactory factory = new ActionFactory();
        ActionCommand actionCommand = factory.defineCommand(command);
        return actionCommand.execute(params);
    }
}
