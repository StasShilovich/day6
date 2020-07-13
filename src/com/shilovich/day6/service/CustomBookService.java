package com.shilovich.day6.service;

import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.service.exception.CustomBookValidationException;

import java.util.List;

public interface CustomBookService {
    public void addBook(CustomBook book) throws CustomBookValidationException;

    public void removeBook(CustomBook book) throws CustomBookValidationException;

    public CustomBook findByTag(int tag) throws CustomBookValidationException;

    public List<CustomBook> sortBookByTag();
}
