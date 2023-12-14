package ru.yandex.practicum.filmorate.exception.rating;

public class RatingNotFoundException extends RuntimeException {

    public RatingNotFoundException(String message) {
        super(message);
    }

    public RatingNotFoundException(long id) {
        super(String.format("Rating from User with id %s. not found", id));
    }
}