package com.shilovich.day6;

import com.shilovich.day6.controller.CustomBookStorageController;
import com.shilovich.day6.model.entity.CustomBook;

import java.math.BigDecimal;
import java.math.MathContext;

public class Main {
    public static void main(String[] args) {
        CustomBook book = new CustomBook(47966, "W.G. Sebald", "Vertigo", 1990, new BigDecimal(9.49, MathContext.DECIMAL64));
        CustomBookStorageController controller = CustomBookStorageController.getInstance();
        controller.addBook(book);
        controller.removeBook(book);
        CustomBook byTag = controller.findByTag(47965);
        System.out.println(byTag);
        System.out.println(controller.sortBookByTag());
    }
}
