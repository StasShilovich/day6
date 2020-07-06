package com.shilovich.day6.service;

import com.shilovich.day6.entity.CustomBook;

import java.util.List;

public interface CustomBookListDAO {
    boolean addBook(CustomBook book);

    boolean removeBook(CustomBook book);
    // TODO: 05.07.2020 throws Exception

    CustomBook findByTag(int tag);

    List<CustomBook> sortBookByTag();
}
