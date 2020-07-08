package com.shilovich.day6.model.dao;

import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.model.exception.CustomBookCRUDException;

import java.util.List;

public interface CustomBookListDao {
    void addBook(CustomBook book) throws CustomBookCRUDException;

    void removeBook(CustomBook book) throws CustomBookCRUDException;

    CustomBook findByTag(int tag);

    List<CustomBook> sortBookByTag();
}
