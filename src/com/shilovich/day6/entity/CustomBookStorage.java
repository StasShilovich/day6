package com.shilovich.day6.entity;

import java.util.List;

public class CustomBookStorage {
    private static CustomBookStorage instance;
    private List<CustomBook> books;

    private CustomBookStorage() {
    }

    public static CustomBookStorage getInstance() {
        if (instance == null) {
            instance = new CustomBookStorage();
        }
        return instance;
    }

    public CustomBook getBook(int index) {
        return books.get(index);
    }

    public boolean setBook(CustomBook book) {
        boolean result = false;
        if (book != null) {
            this.books.add(book);
            result = true;
        }
        return result;
    }

    public boolean setBooks(List<CustomBook> books) {
        boolean result = false;
        if (!books.isEmpty()) {
            this.books = books;
            result = true;
        }
        return result;
    }

    public boolean deleteBook(CustomBook book) {
        return books.remove(book);
    }

    public int size() {
        return books.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomBookStorage)) return false;

        CustomBookStorage that = (CustomBookStorage) o;

        return books.equals(that.books);
    }

    @Override
    public int hashCode() {
        return books != null ? books.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomBookStorage{");
        sb.append("books=").append(books);
        sb.append('}');
        return sb.toString();
    }
}
