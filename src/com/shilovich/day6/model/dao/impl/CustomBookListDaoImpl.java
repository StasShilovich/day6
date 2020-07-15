package com.shilovich.day6.model.dao.impl;

import com.shilovich.day6.exception.DaoException;
import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.model.entity.CustomBookStorage;
import com.shilovich.day6.model.dao.CustomBookListDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomBookListDaoImpl implements CustomBookListDao {
    private static final int NOT_FOUND_INDEX = -1;

    private static CustomBookListDaoImpl instance;

    private CustomBookListDaoImpl() {
    }

    public static CustomBookListDaoImpl getInstance() {
        if (instance == null) {
            return new CustomBookListDaoImpl();
        }
        return instance;
    }

    @Override
    public void addBook(CustomBook book) throws DaoException {
        if (findCustomBookIndex(book) == NOT_FOUND_INDEX) {
            CustomBookStorage.getInstance().setBook(book);
        } else {
            throw new DaoException("Book is already exist! " + book.toString());
        }
    }

    @Override
    public void removeBook(CustomBook book) throws DaoException {
        int index = findCustomBookIndex(book);
        if (index != NOT_FOUND_INDEX) {
            CustomBookStorage.getInstance().deleteBook(index);
        } else {
            throw new DaoException("This book is not in storage! " + book.toString());
        }
    }

    @Override
    public CustomBook findByTag(int tag) throws DaoException {
        CustomBook result = new CustomBook();
        boolean isExist = false;
        int size = CustomBookStorage.getInstance().size();
        checkStorage(size);
        for (int i = 0; i < size; i++) {
            CustomBook book = CustomBookStorage.getInstance().getBook(i);
            if (book.getTag() == tag) {
                result = book;
                isExist = true;
            }
        }
        if (!isExist) {
            System.out.println("Book is not found!");
        }
        return result;
    }

    @Override
    public List<CustomBook> sortBookByTag() throws DaoException {
        CustomBookStorage storage = CustomBookStorage.getInstance();
        checkStorage(storage.size());
        List<CustomBook> result = new ArrayList<>();
        for (int i = 0; i < storage.size(); i++) {
            CustomBook book = storage.getBook(i);
            result.add(book);
        }
        Collections.sort(result, new Comparator<CustomBook>() {
            @Override
            public int compare(CustomBook book1, CustomBook book2) {
                return book1.getTag() - book2.getTag();
            }
        });
        return result;
    }

    private int findCustomBookIndex(CustomBook book) throws DaoException {
        int index = NOT_FOUND_INDEX;
        int size = CustomBookStorage.getInstance().size();
        checkStorage(size);
        for (int i = 0; i < size; i++) {
            CustomBook existBook = CustomBookStorage.getInstance().getBook(i);
            if (existBook.getTag() == book.getTag()) {
                index = i;
            }
        }
        return index;
    }

    private void checkStorage(int size) throws DaoException {
        if (size == 0) {
            throw new DaoException("Storage is empty!");
        }
    }
}
