package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.yandex.practicum.filmorate.exception.film.*;
import ru.yandex.practicum.filmorate.exception.genre.*;
import ru.yandex.practicum.filmorate.exception.mpa.*;
import ru.yandex.practicum.filmorate.exception.user.*;
import ru.yandex.practicum.filmorate.exception.rating.*;



@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler({NullPointerException.class, FilmNotFoundException.class, UserNotFoundException.class,
            GenreNotFoundException.class, MpaNotFoundException.class, RatingNotFoundException.class, IndexOutOfBoundsException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(final RuntimeException exception) {
        log.error(String.format("ERROR! %s: %s", exception.getClass().getSimpleName(), exception.getMessage()));
        return new ErrorResponse(exception.getMessage());
    }

    @ExceptionHandler({FilmValidationException.class, UserValidationException.class, GenreValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(final javax.validation.ValidationException exception) {
        log.error(String.format("ERROR! %s: %s", exception.getClass().getSimpleName(), exception.getMessage()));
        return new ErrorResponse(exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleThrowable(final Throwable exception) {
        log.error(String.format("ERROR! %s: %s", exception.getClass().getSimpleName(), exception));
        return new ErrorResponse("ERROR! Something went wrong!" + exception);
    }

    private static class ErrorResponse {
        String error;

        public ErrorResponse(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }
    }
}
