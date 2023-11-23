package ru.yandex.practicum.filmorate.exception.user;

import javax.validation.ValidationException;

public class UserValidationException extends ValidationException {

    public UserValidationException(String message) {
        super(message);
    }
}