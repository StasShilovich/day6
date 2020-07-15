package com.shilovich.day6.controller.command.impl;

import com.shilovich.day6.controller.command.ActionCommand;
import com.shilovich.day6.exception.ControllerException;
import com.shilovich.day6.exception.ServiceException;
import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.service.impl.CustomBookServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class FindByTagCommand implements ActionCommand<String, CustomBook, Integer> {
    private static final String TAG_REQ = "Tag";
    private static final String BOOK_RESP = "Book";

    private final CustomBookServiceImpl service;

    public FindByTagCommand() {
        this.service = CustomBookServiceImpl.getInstance();
    }

    @Override
    public Map<String, CustomBook> execute(Map<String, Integer> parameters) throws ControllerException {
        int tag = parameters.get(TAG_REQ);
        CustomBook byTag;
        try {
            byTag = service.findByTag(tag);
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
        Map<String, CustomBook> result = new HashMap<>();
        result.put(BOOK_RESP, byTag);
        return result;
    }
}
