package com.shilovich.day6.model.exception;

public class CustomBookCRUDException extends Exception{
    public CustomBookCRUDException() {
        super();
    }

    public CustomBookCRUDException(String message) {
        super(message);
    }

    public CustomBookCRUDException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomBookCRUDException(Throwable cause) {
        super(cause);
    }
}
