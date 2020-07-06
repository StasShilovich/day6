package com.shilovich.day6;

import com.shilovich.day6.entity.CustomBook;
import com.shilovich.day6.service.CustomBookListDAO;
import com.shilovich.day6.service.impl.CustomBookListDAOImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomBookListDAO bookListDAO=new CustomBookListDAOImpl();
        List<CustomBook> customBooks = bookListDAO.sortBookByTag();
        System.out.println(customBooks);
    }
}
