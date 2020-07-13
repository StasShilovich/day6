package com.shilovich.day6.controller.invoker;

import com.shilovich.day6.controller.command.ActionCommand;
import com.shilovich.day6.controller.provider.ActionProvider;

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
        ActionProvider provider = new ActionProvider();
        ActionCommand actionCommand = provider.defineCommand(command);
        return actionCommand.execute(params);
    }
}
