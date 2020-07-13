package com.shilovich.day6.controller.command.impl;

import com.shilovich.day6.controller.command.ActionCommand;
import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.service.exception.CustomBookValidationException;
import com.shilovich.day6.service.impl.CustomBookServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class RemoveBookCommand implements ActionCommand {
    private static final String BOOK_REQ = "Book";
    private static final String IS_REMOVED_RESP = "isRemoved";

    private final CustomBookServiceImpl service;

    public RemoveBookCommand() {
        this.service = CustomBookServiceImpl.getInstance();
    }

    @Override
    public Map execute(Map parameters) {
        CustomBook book = (CustomBook) parameters.get(BOOK_REQ);
        // TODO: 13.07.2020 valid book
        boolean isRemoved = false;
        try {
            service.removeBook(book);
            isRemoved = true;
        } catch (CustomBookValidationException e) {
            System.out.println(e.getMessage());
        }
        Map<String, Boolean> result = new HashMap<>();
        result.put(IS_REMOVED_RESP, isRemoved);
        return result;
    }
}
