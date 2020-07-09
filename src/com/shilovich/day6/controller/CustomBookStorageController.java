package com.shilovich.day6.controller;

import com.shilovich.day6.model.dao.CustomBookListDao;
import com.shilovich.day6.model.dao.impl.CustomBookListDaoImpl;
import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.model.exception.CustomBookCRUDException;

import java.util.List;

public class CustomBookStorageController {
    private static CustomBookStorageController instance;

    private CustomBookStorageController() {
    }

    public static CustomBookStorageController getInstance() {
        if (instance == null) {
            return new CustomBookStorageController();
        }
        return instance;
    }

    public void addBook(CustomBook book) {
        if (book == null) {
            System.out.println("Book is null!");
            return;
        }
        CustomBookListDao dao = CustomBookListDaoImpl.getInstance();
        try {
            dao.addBook(book);
            System.out.println("Book is successfully add!");
        } catch (CustomBookCRUDException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeBook(CustomBook book) {
        if (book == null) {
            System.out.println("Book is null!");
            return;
        }
        CustomBookListDao dao = CustomBookListDaoImpl.getInstance();
        try {
            dao.removeBook(book);
            System.out.println("Book is successfully removed!");
        } catch (CustomBookCRUDException e) {
            System.out.println(e.getMessage());
        }
    }

    public CustomBook findByTag(int tag) {
        if (tag == 0) {
            System.out.println("Tag is null!");
            return new CustomBook();
        }
        CustomBookListDao dao = CustomBookListDaoImpl.getInstance();
        CustomBook bookByTag = dao.findByTag(tag);
        return bookByTag;
    }

    public List<CustomBook> sortBookByTag() {
        CustomBookListDao dao = CustomBookListDaoImpl.getInstance();
        List<CustomBook> customBooks = dao.sortBookByTag();
        return customBooks;
    }
}
