package com.shilovich.day6.controller.command.impl;

import com.shilovich.day6.controller.command.ActionCommand;
import com.shilovich.day6.exception.ControllerException;
import com.shilovich.day6.exception.ServiceException;
import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.service.impl.CustomBookServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingByTagCommand implements ActionCommand<String, List<CustomBook>, String> {
    private static final String SORT_BOOKS_RESP = "Books";

    private final CustomBookServiceImpl service;

    public SortingByTagCommand() {
        this.service = CustomBookServiceImpl.getInstance();
    }

    @Override
    public Map<String, List<CustomBook>> execute(Map<String, String> parameters) throws ControllerException {
        List<CustomBook> customBooks;
        try {
            customBooks = service.sortBookByTag();
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
        Map<String, List<CustomBook>> map = new HashMap<>();
        map.put(SORT_BOOKS_RESP, customBooks);
        return map;
    }
}
