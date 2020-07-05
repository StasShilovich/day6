package com.shilovich.day6;

import com.shilovich.day6.entity.CustomBook;
import com.shilovich.day6.exception.CustomBookReaderException;
import com.shilovich.day6.parser.CustomBookParser;
import com.shilovich.day6.reader.CustomBookReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomBookReader reader = new CustomBookReader();
        String data = "";
        try {
            data = reader.readFile();
        } catch (CustomBookReaderException e) {
            e.printStackTrace();
        }
        CustomBookParser parser = new CustomBookParser();
        List<CustomBook> customBooks = parser.parse(data);
        for (CustomBook customBook : customBooks) {
            System.out.println(customBook);
        }
    }
}
