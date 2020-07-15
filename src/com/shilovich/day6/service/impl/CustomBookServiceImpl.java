package com.shilovich.day6.service.impl;

import com.shilovich.day6.exception.DaoException;
import com.shilovich.day6.exception.ServiceException;
import com.shilovich.day6.model.dao.impl.CustomBookListDaoImpl;
import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.service.CustomBookService;
import com.shilovich.day6.service.validator.CustomBookValidator;

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

    public void addBook(CustomBook book) throws ServiceException {
        CustomBookValidator validator = new CustomBookValidator();
        if (!validator.validateCustomBook(book)) {
            throw new ServiceException("Book is not valid!");
        }
        try {
            CustomBookListDaoImpl.getInstance().addBook(book);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        System.out.println("Book is successfully add!");
    }

    public void removeBook(CustomBook book) throws ServiceException {
        CustomBookValidator validator = new CustomBookValidator();
        if (!validator.validateCustomBook(book)) {
            throw new ServiceException("Book is not valid!");
        }
        try {
            CustomBookListDaoImpl.getInstance().removeBook(book);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        System.out.println("Book is successfully removed!");
    }

    public CustomBook findByTag(int tag) throws ServiceException {
        CustomBookValidator validator = new CustomBookValidator();
        if (!validator.validateTag(tag)) {
            throw new ServiceException("Tag is not valid!");
        }
        CustomBook book;
        try {
            book = CustomBookListDaoImpl.getInstance().findByTag(tag);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return book;
    }

    public List<CustomBook> sortBookByTag() throws ServiceException {
        List<CustomBook> books;
        try {
            books = CustomBookListDaoImpl.getInstance().sortBookByTag();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return books;
    }
}
