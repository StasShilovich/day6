package com.shilovich.day6.service;

import com.shilovich.day6.entity.CustomBook;

public interface CustomBookListDAO {
    boolean addBook(CustomBook book);

    boolean removeBook();
    // TODO: 05.07.2020 throws Exception

    CustomBook findByTag();

    void sortBookByTag();
}
