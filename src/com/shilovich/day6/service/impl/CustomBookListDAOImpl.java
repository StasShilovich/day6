package com.shilovich.day6.service.impl;

import com.shilovich.day6.creator.CustomBookStorageCreator;
import com.shilovich.day6.entity.CustomBook;
import com.shilovich.day6.entity.CustomBookStorage;
import com.shilovich.day6.service.CustomBookListDAO;
import com.shilovich.day6.validator.CustomBookValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomBookListDAOImpl implements CustomBookListDAO {

    @Override
    public boolean addBook(CustomBook book) {
        CustomBookValidator validator = new CustomBookValidator();
        if (!validator.validateCustomBook(book)) {
            System.out.println("Book is not valid!");
            return false;
        }
        CustomBookStorage.getInstance().setBook(book);
        return true;
    }

    @Override
    public boolean removeBook(CustomBook book) {
        CustomBookValidator validator = new CustomBookValidator();
        if (!validator.validateCustomBook(book)) {
            System.out.println("Book is not valid!");
            return false;
        }
        int size = CustomBookStorage.getInstance().size();
        for (int i = 0; i < size; i++) {
            CustomBook customBook = CustomBookStorage.getInstance().getBook(i);
            if (customBook.equals(book)) {
                CustomBookStorage.getInstance().deleteBook(book);
            }
        }
        return true;
    }

    @Override
    public CustomBook findByTag(int tag) {
        CustomBookValidator validator = new CustomBookValidator();
        if (!validator.validateTag(tag)) {
            System.out.println("Tag is not valid!");
            return new CustomBook();
        }
        CustomBook result = new CustomBook();
        int size = CustomBookStorage.getInstance().size();
        for (int i = 0; i < size; i++) {
            CustomBook book = CustomBookStorage.getInstance().getBook(i);
            if (book.getTag() == tag) {
                result = book;
            }
        }
        return result;
    }

    @Override
    public List<CustomBook> sortBookByTag() {
        CustomBookStorageCreator creator = new CustomBookStorageCreator();
        CustomBookStorage storage = creator.create();
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

}
