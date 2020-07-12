package com.shilovich.day6.controller.command.impl;

import com.shilovich.day6.controller.command.ActionCommand;

import java.util.Map;

public class EmptyCommand implements ActionCommand {

    @Override
    public Map<String, String> execute(Map<String, String> parameters) {
        return null;
    }
}
