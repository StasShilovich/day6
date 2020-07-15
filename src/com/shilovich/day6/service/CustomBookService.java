package com.shilovich.day6.service;

import com.shilovich.day6.exception.ServiceException;
import com.shilovich.day6.model.entity.CustomBook;

import java.util.List;

public interface CustomBookService {
    public void addBook(CustomBook book) throws ServiceException;

    public void removeBook(CustomBook book) throws ServiceException;

    public CustomBook findByTag(int tag) throws ServiceException;

    public List<CustomBook> sortBookByTag() throws ServiceException;
}
