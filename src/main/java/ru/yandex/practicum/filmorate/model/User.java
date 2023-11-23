package ru.yandex.practicum.filmorate.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
public class User {
    private Integer id;
    @NonNull
    @NotBlank
    @Email
    private String email;
    private String login;
    private String name;
    private LocalDate birthday;
}
