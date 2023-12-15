package ru.yandex.practicum.filmorate.validator;

import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;

import static ru.yandex.practicum.filmorate.constants.Constants.EMAIL_REGEX_PATTERN;
import static ru.yandex.practicum.filmorate.constants.Constants.LOGIN_REGEX_PATTERN;
import static ru.yandex.practicum.filmorate.validator.PatternValidator.isPatternMatches;

public class UserValidator {

    public static boolean isUserValid(User user) {
        if (user.getId() != null && user.getId() <= 0) {
            throw new ValidationException("Id should be positive or null.");
        } else if (!isPatternMatches(user.getEmail(), EMAIL_REGEX_PATTERN)) {
            throw new ValidationException("Email validation error.");
        } else if (!isPatternMatches(user.getLogin(), LOGIN_REGEX_PATTERN)) {
            throw new ValidationException("Login validation error.");
        } else if (user.getBirthday().isAfter(LocalDate.now())) {
            throw new ValidationException("Birthday day can't be in future.");
        } else {
            if (user.getName().isBlank()) {
                user.setName(user.getLogin());
            }
            return true;
        }
    }

    public static boolean isUserNameValid(String userName) {
        return !userName.isBlank();
    }
}