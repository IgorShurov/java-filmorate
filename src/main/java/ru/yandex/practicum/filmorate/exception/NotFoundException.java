package ru.yandex.practicum.filmorate.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
            super(message);
        }

    public NotFoundException(String name, Long id) {
        super(String.format("Error: %s. with id %d not found.", name, id));
    }
}
