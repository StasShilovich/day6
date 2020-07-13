package com.shilovich.day6.controller.command.impl;

import com.shilovich.day6.controller.command.ActionCommand;
import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.service.exception.CustomBookValidationException;
import com.shilovich.day6.service.impl.CustomBookServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class FindByTagCommand implements ActionCommand {
    private static final String TAG_REQ = "Tag";
    private static final String BOOK_RESP = "Book";

    private final CustomBookServiceImpl service;

    public FindByTagCommand() {
        this.service = CustomBookServiceImpl.getInstance();
    }

    @Override
    public Map execute(Map parameters) {
        int tag = (int) parameters.get(TAG_REQ);
        // TODO: 13.07.2020 valid tag
        CustomBook byTag = new CustomBook();
        try {
            byTag = service.findByTag(tag);
        } catch (CustomBookValidationException e) {
            System.out.println(e.getMessage());
        }
        Map<String, CustomBook> result = new HashMap<>();
        result.put(BOOK_RESP, byTag);
        return result;
    }
}
