package com.shilovich.day6.parser;

import com.shilovich.day6.entity.CustomBook;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomBookParser {

    private static final String LINE_REGEX = "\\r?\\n";
    private static final String CUSTOM_BOOK_REGEX = ";";
    private static final int CUSTOM_BOOK_VALUES = 5;

    public List<CustomBook> parse(String data) {
        List<CustomBook> customBooks = new ArrayList<>();
        String[] booksString = data.split(LINE_REGEX);
        for (String book : booksString) {
            customBooks.add(parseStringToBook(book));
        }
        return customBooks;
    }

    private CustomBook parseStringToBook(String book) {
        CustomBook customBook = new CustomBook();
        String[] values = book.split(CUSTOM_BOOK_REGEX);
        if (values.length == CUSTOM_BOOK_VALUES) {
            customBook.setTag(Integer.parseInt(values[0].trim()));
            customBook.setAuthor(values[1].trim());
            customBook.setTitle(values[2].trim());
            customBook.setYear(Integer.parseInt(values[3].trim()));
            customBook.setPrice(new BigDecimal(values[4].trim()));
        }
        return customBook;
    }
}
