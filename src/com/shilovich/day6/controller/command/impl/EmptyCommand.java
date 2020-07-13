package com.shilovich.day6.controller.command.impl;

import com.shilovich.day6.controller.command.ActionCommand;

import java.util.HashMap;
import java.util.Map;

public class EmptyCommand implements ActionCommand {
    @Override
    public Map execute(Map parameters) {
        System.out.println("Empty command!");
        return new HashMap<>();
    }
}
