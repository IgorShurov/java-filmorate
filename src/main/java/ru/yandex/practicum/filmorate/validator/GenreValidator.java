package ru.yandex.practicum.filmorate.validator;

import org.apache.commons.lang3.StringUtils;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Genre;

public class GenreValidator {

    public static boolean isGenreValid(Genre genre) {
        if (StringUtils.isBlank(genre.getName())) {
            throw new ValidationException(String.format("Genre name can not be blank. %s", genre));
        }
        return true;
    }
}