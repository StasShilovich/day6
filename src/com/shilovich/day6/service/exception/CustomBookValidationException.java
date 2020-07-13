package com.shilovich.day6.service.exception;

public class CustomBookValidationException extends Exception{
    public CustomBookValidationException() {
        super();
    }

    public CustomBookValidationException(String message) {
        super(message);
    }

    public CustomBookValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomBookValidationException(Throwable cause) {
        super(cause);
    }
}
