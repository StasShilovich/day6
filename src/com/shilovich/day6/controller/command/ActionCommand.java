package com.shilovich.day6.controller.command;

import java.util.List;
import java.util.Map;

public interface ActionCommand {
    Map execute(Map<String, String> params);
}
