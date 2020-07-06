package com.shilovich.day6.validator;

import com.shilovich.day6.entity.CustomBook;

import java.math.BigDecimal;
import java.util.Calendar;

public class CustomBookValidator {
    private static final int TOP_BORDER_TAG = 99999;
    private static final int BOTTOM_BORDER_TAG = 10000;
    private static final int AUTHOR_NAME_LENGTH = 20;
    private static final int TITLE_NAME_LENGTH = 50;
    private static final int TOP_PRICE = 250;
    private static final int ZERO = 0;

    public boolean validateCustomBook(CustomBook book) {
        boolean result = false;
        if (book == null) {
            return false;
        }
        if (validateTag(book.getTag()) ||
                validateAuthor(book.getAuthor()) ||
                validateTitle(book.getTitle()) ||
                validateYear(book.getYear()) ||
                validatePrice(book.getPrice())) {
            result = true;
        }
        return result;
    }

    public boolean validateTag(int tag) {
        return tag >= BOTTOM_BORDER_TAG && tag <= TOP_BORDER_TAG;
    }

    private boolean validateAuthor(String author) {
        return author.length() <= AUTHOR_NAME_LENGTH;
    }

    private boolean validateTitle(String title) {
        return title.length() <= TITLE_NAME_LENGTH;
    }

    private boolean validateYear(int year) {
        return year <= Calendar.getInstance().get(Calendar.YEAR);
    }

    private boolean validatePrice(BigDecimal price) {
        return price.intValue() < TOP_PRICE && price.intValue() > ZERO;
    }
}
