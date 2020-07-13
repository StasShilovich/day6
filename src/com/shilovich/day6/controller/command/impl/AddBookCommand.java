package com.shilovich.day6.controller.command.impl;

import com.shilovich.day6.controller.command.ActionCommand;
import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.service.exception.CustomBookValidationException;
import com.shilovich.day6.service.impl.CustomBookServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class AddBookCommand implements ActionCommand {
    private static final String BOOK_REQ = "Book";
    private static final String IS_ADD_RESP = "isADD";

    private final CustomBookServiceImpl service;

    public AddBookCommand() {
        this.service = CustomBookServiceImpl.getInstance();
    }

    @Override
    public Map execute(Map parameters) {
        CustomBook book = (CustomBook) parameters.get(BOOK_REQ);
        // TODO: 13.07.2020 valid book
        boolean isAdd = false;
        try {
            service.addBook(book);
            isAdd = true;
        } catch (CustomBookValidationException e) {
            System.out.println(e.getMessage());
        }
        Map<String, Boolean> result = new HashMap<>();
        result.put(IS_ADD_RESP, isAdd);
        return result;
    }
}
