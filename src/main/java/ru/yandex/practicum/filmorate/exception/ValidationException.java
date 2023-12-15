package ru.yandex.practicum.filmorate.exception;

public class ValidationException extends javax.validation.ValidationException {

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String name, String massage) {
        super(String.format("Error: %s validation error.", name, massage));
    }
}
