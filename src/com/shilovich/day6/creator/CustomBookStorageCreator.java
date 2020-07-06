package com.shilovich.day6.creator;

import com.shilovich.day6.entity.CustomBook;
import com.shilovich.day6.entity.CustomBookStorage;
import com.shilovich.day6.exception.CustomBookReaderException;
import com.shilovich.day6.parser.CustomBookParser;
import com.shilovich.day6.reader.CustomBookReader;

import java.util.List;

public class CustomBookStorageCreator {
    public CustomBookStorage create() {
        CustomBookReader reader = new CustomBookReader();
        String data = "";
        try {
            data = reader.readFile();
        } catch (CustomBookReaderException e) {
            e.printStackTrace();
        }
        CustomBookParser parser = new CustomBookParser();
        List<CustomBook> customBooks = parser.parse(data);
        CustomBookStorage storage = CustomBookStorage.getInstance();
        boolean isStorageFilled = storage.setBooks(customBooks);
        if (isStorageFilled) {
            System.out.println("Storage filled with books!");
        } else {
            System.out.println("Storage not filled with books. Books list is empty!");
        }
        return storage;
    }
}
