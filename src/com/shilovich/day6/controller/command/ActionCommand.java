package com.shilovich.day6.controller.command;

import com.shilovich.day6.exception.ControllerException;

import java.util.Map;

public interface ActionCommand<A, T, K> {
    Map<A, T> execute(Map<A, K> params) throws ControllerException;
}
