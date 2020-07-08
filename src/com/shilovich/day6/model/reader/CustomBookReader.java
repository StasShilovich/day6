package com.shilovich.day6.model.reader;

import com.shilovich.day6.model.exception.CustomBookReaderException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomBookReader {
    private static final String PATH = "src\\resources\\books.txt";

    public String readFile() throws CustomBookReaderException {
        String result = "";
        try {
            result = new String(Files.readAllBytes(Paths.get(PATH)));
        } catch (IOException e) {
            throw new CustomBookReaderException("Custom book reading fail!", e);
        }
        return result;
    }

}
