package com.shilovich.day6.model.entity;

import com.shilovich.day6.model.creator.CustomBookStorageCreator;

import java.util.List;

public class CustomBookStorage {
    private static final int STORAGE_CAPACITY = 100;
    private static CustomBookStorage instance;

    private List<CustomBook> books;

    private CustomBookStorage() {
    }

    public static CustomBookStorage getInstance() {
        if (instance == null) {
            instance = CustomBookDefaultStorage();
        }
        return instance;
    }

    private static CustomBookStorage CustomBookDefaultStorage() {
        CustomBookStorageCreator creator = new CustomBookStorageCreator();
        List<CustomBook> customBooks = creator.create();
        CustomBookStorage storage = new CustomBookStorage();
        boolean isStorageFilled = storage.setBooks(customBooks);
        if (isStorageFilled) {
            System.out.println("Storage filled with books!");
        } else {
            System.out.println("Storage not filled with books. Books list is empty!");
        }
        return storage;
    }

    public CustomBook getBook(int index) {
        return books.get(index);
    }

    public boolean setBook(CustomBook book) {
        boolean result = false;
        if (book != null && books.size() < STORAGE_CAPACITY) {
            this.books.add(book);
            result = true;
        }
        return result;
    }

    public boolean setBooks(List<CustomBook> books) {
        boolean result = false;
        if (!books.isEmpty() && books.size() <= STORAGE_CAPACITY) {
            this.books = books;
            result = true;
        }
        return result;
    }

    public boolean deleteBook(int index) {
        return books.remove(getBook(index));
    }

    public int size() {
        return books.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomBookStorage{");
        sb.append("books=").append(books);
        sb.append('}');
        return sb.toString();
    }
}
