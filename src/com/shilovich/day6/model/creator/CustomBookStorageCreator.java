package com.shilovich.day6.model.creator;

import com.shilovich.day6.model.entity.CustomBook;
import com.shilovich.day6.model.entity.CustomBookStorage;
import com.shilovich.day6.model.exception.CustomBookReaderException;
import com.shilovich.day6.model.parser.CustomBookParser;
import com.shilovich.day6.model.reader.CustomBookReader;

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
