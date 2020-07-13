package com.shilovich.day6.controller.command;

import java.util.Map;

public interface ActionCommand {
    Map execute(Map params);
}
