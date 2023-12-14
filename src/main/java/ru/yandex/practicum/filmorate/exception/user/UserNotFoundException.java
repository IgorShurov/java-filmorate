package ru.yandex.practicum.filmorate.exception.user;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(long id) {
        super(String.format("User with id %s. not found", id));
    }
}