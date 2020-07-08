package com.shilovich.day6.model;

import com.shilovich.day6.model.creator.CustomBookStorageCreator;
import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.model.dao.CustomBookListDao;
import com.shilovich.day6.model.dao.impl.CustomBookListDaoImpl;
import com.shilovich.day6.model.entity.CustomBookStorage;
import com.shilovich.day6.model.exception.CustomBookCRUDException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomBookStorage storage = new CustomBookStorageCreator().create();
        CustomBookListDao bookListDAO = CustomBookListDaoImpl.getInstance(storage);
        CustomBook book = new CustomBook(47965, "W.G. Sebald", "Vertigo", 1990, new BigDecimal(9.49, MathContext.DECIMAL64));
        try {
            bookListDAO.addBook(book);
        } catch (CustomBookCRUDException e) {
            System.out.println(e.getMessage());
        }
        bookListDAO.sortBookByTag();
        System.out.println(storage);
    }
}
