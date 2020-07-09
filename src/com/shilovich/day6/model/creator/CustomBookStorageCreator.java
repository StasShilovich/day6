package com.shilovich.day6.model.creator;

import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.model.exception.CustomBookReaderException;
import com.shilovich.day6.model.parser.CustomBookParser;
import com.shilovich.day6.model.reader.CustomBookReader;

import java.util.List;

public class CustomBookStorageCreator {
    public List<CustomBook> create() {
        CustomBookReader reader = new CustomBookReader();
        String data = "";
        try {
            data = reader.readFile();
        } catch (CustomBookReaderException e) {
            System.out.println(e.getMessage());
        }
        CustomBookParser parser = new CustomBookParser();
        return parser.parse(data);
    }
}
