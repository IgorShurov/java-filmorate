package ru.yandex.practicum.filmorate.validator;

import ru.yandex.practicum.filmorate.exception.user.UserValidationException;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;

import static ru.yandex.practicum.filmorate.constants.Constants.EMAIL_REGEX_PATTERN;
import static ru.yandex.practicum.filmorate.constants.Constants.LOGIN_REGEX_PATTERN;
import static ru.yandex.practicum.filmorate.validator.PatternValidator.isPatternMatches;

public class UserValidator {

    public static boolean isUserValid(User user) {
        if (user.getId() != null && user.getId() <= 0) {
            throw new UserValidationException("Id should be positive or null.");
        } else if (!isPatternMatches(user.getEmail(), EMAIL_REGEX_PATTERN)) {
            throw new UserValidationException("Email validation error.");
        } else if (!isPatternMatches(user.getLogin(), LOGIN_REGEX_PATTERN)) {
            throw new UserValidationException("Login validation error.");
        } else if (user.getBirthday().isAfter(LocalDate.now())) {
            throw new UserValidationException("Birthday day can't be in future.");
        } else {
            return true;
        }
    }

    public static boolean isUserNameValid(String userName) {
        return !userName.isBlank();
    }
}