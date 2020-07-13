package com.shilovich.day6.model.dao;

import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.service.exception.CustomBookValidationException;

import java.util.List;

public interface CustomBookListDao {
    void addBook(CustomBook book) throws CustomBookValidationException;

    void removeBook(CustomBook book) throws CustomBookValidationException;

    CustomBook findByTag(int tag);

    List<CustomBook> sortBookByTag();
}
