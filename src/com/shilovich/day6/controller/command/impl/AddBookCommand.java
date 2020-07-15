package com.shilovich.day6.controller.command.impl;

import com.shilovich.day6.controller.command.ActionCommand;
import com.shilovich.day6.exception.ControllerException;
import com.shilovich.day6.exception.ServiceException;
import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.service.impl.CustomBookServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class AddBookCommand implements ActionCommand<String, Boolean, CustomBook> {
    private static final String BOOK_REQ = "Book";
    private static final String IS_ADD_RESP = "isADD";

    private final CustomBookServiceImpl service;

    public AddBookCommand() {
        this.service = CustomBookServiceImpl.getInstance();
    }

    @Override
    public Map<String, Boolean> execute(Map<String, CustomBook> parameters) throws ControllerException {
        CustomBook book = parameters.get(BOOK_REQ);
        boolean isAdd;
        try {
            service.addBook(book);
            isAdd = true;
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
        Map<String, Boolean> result = new HashMap<>();
        result.put(IS_ADD_RESP, isAdd);
        return result;
    }
}
