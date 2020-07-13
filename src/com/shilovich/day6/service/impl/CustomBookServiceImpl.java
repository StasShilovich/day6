package com.shilovich.day6.service.impl;

import com.shilovich.day6.model.dao.CustomBookListDao;
import com.shilovich.day6.model.dao.impl.CustomBookListDaoImpl;
import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.service.CustomBookService;
import com.shilovich.day6.service.exception.CustomBookValidationException;
import com.shilovich.day6.validator.CustomBookValidator;

import java.util.List;

public class CustomBookServiceImpl implements CustomBookService {
    private static CustomBookServiceImpl instance;

    private CustomBookServiceImpl() {
    }

    public static CustomBookServiceImpl getInstance() {
        if (instance == null) {
            return new CustomBookServiceImpl();
        }
        return instance;
    }

    public void addBook(CustomBook book) throws CustomBookValidationException {
        CustomBookValidator validator = new CustomBookValidator();
        if (!validator.validateCustomBook(book)) {
            throw new CustomBookValidationException("Book is not valid!");
        }
        CustomBookListDao dao = CustomBookListDaoImpl.getInstance();
        dao.addBook(book);
        System.out.println("Book is successfully add!");
    }

    public void removeBook(CustomBook book) throws CustomBookValidationException {
        CustomBookValidator validator = new CustomBookValidator();
        if (!validator.validateCustomBook(book)) {
            throw new CustomBookValidationException("Book is not valid!");
        }
        CustomBookListDao dao = CustomBookListDaoImpl.getInstance();
        dao.removeBook(book);
        System.out.println("Book is successfully removed!");
    }

    public CustomBook findByTag(int tag) throws CustomBookValidationException {
        CustomBookValidator validator = new CustomBookValidator();
        if (!validator.validateTag(tag)) {
            throw new CustomBookValidationException("Tag is not valid!");
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
