package com.shilovich.day6.exception;

public class CustomBookReaderException extends Exception {
    public CustomBookReaderException() {
        super();
    }

    public CustomBookReaderException(String message) {
        super(message);
    }

    public CustomBookReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomBookReaderException(Throwable cause) {
        super(cause);
    }
}
