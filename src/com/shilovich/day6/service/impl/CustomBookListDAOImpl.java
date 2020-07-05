package com.shilovich.day6.service.impl;

import com.shilovich.day6.entity.CustomBook;
import com.shilovich.day6.service.CustomBookListDAO;

public class CustomBookListDAOImpl implements CustomBookListDAO {


    @Override
    public boolean addBook(CustomBook book) {
        return false;
    }

    @Override
    public boolean removeBook() {
        return false;
    }

    @Override
    public CustomBook findByTag() {
        return null;
    }

    @Override
    public void sortBookByTag() {

    }
}
