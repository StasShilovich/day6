package com.shilovich.day6.controller.command.impl;

import com.shilovich.day6.controller.command.ActionCommand;
import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.service.CustomBookService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingByTagCommand implements ActionCommand {
    private static final String SORT_BOOKS = "Books";
    private CustomBookService service;

    public SortingByTagCommand() {
        this.service = CustomBookService.getInstance();
    }

    @Override
    public Map execute(Map<String, String> parameters) {
        List<CustomBook> customBooks = service.sortBookByTag();
        Map<String, List<CustomBook>> map = new HashMap<>();
        map.put(SORT_BOOKS, customBooks);
        return map;
    }
}
