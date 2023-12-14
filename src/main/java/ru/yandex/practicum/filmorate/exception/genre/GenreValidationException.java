package ru.yandex.practicum.filmorate.exception.genre;

public class GenreValidationException extends RuntimeException {

    public GenreValidationException(String message) {
        super(message);
    }
}
