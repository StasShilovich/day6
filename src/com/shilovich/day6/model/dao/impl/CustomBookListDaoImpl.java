package com.shilovich.day6.model.dao.impl;

import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.model.entity.CustomBookStorage;
import com.shilovich.day6.model.dao.CustomBookListDao;
import com.shilovich.day6.model.exception.CustomBookCRUDException;
import com.shilovich.day6.model.validator.CustomBookValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomBookListDaoImpl implements CustomBookListDao {
    private static CustomBookListDaoImpl instance;

    private final CustomBookStorage storage;

    private CustomBookListDaoImpl(CustomBookStorage storage) {
        this.storage = storage;
    }

    public static CustomBookListDaoImpl getInstance(CustomBookStorage storage) {
        if (instance == null) {
            return new CustomBookListDaoImpl(storage);
        }
        return instance;
    }

    @Override
    public void addBook(CustomBook book) throws CustomBookCRUDException {
        CustomBookValidator validator = new CustomBookValidator();
        if (!validator.validateCustomBook(book)) {
            throw new CustomBookCRUDException("Book is not valid!");
        }
        if (findCustomBookIndex(book) != -1) {
            throw new CustomBookCRUDException("Book is already exist!");
        }
        CustomBookStorage.getInstance().setBook(book);
    }

    @Override
    public void removeBook(CustomBook book) throws CustomBookCRUDException {
        CustomBookValidator validator = new CustomBookValidator();
        if (!validator.validateCustomBook(book)) {
            throw new CustomBookCRUDException("Book is not valid!");
        }
        CustomBookStorage.getInstance().deleteBook(findCustomBookIndex(book));
    }

    @Override
    public CustomBook findByTag(int tag) {
        CustomBookValidator validator = new CustomBookValidator();
        if (!validator.validateTag(tag)) {
            System.out.println("Tag is not valid!");
            return new CustomBook();
        }
        CustomBook result = new CustomBook();
        boolean isExist = false;
        int size = CustomBookStorage.getInstance().size();
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
    public List<CustomBook> sortBookByTag() {
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

    private int findCustomBookIndex(CustomBook book) {
        int index = -1;
        int size = CustomBookStorage.getInstance().size();
        for (int i = 0; i < size; i++) {
            CustomBook existBook = CustomBookStorage.getInstance().getBook(i);
            if (existBook.getTag() == book.getTag()) {
                index = i;
            }
        }
        return index;
    }

}
