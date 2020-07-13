package com.shilovich.day6.controller.exception;

public class CommandTypeException extends Exception{
    public CommandTypeException() {
        super();
    }

    public CommandTypeException(String message) {
        super(message);
    }

    public CommandTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandTypeException(Throwable cause) {
        super(cause);
    }
}
