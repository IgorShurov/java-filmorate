package ru.yandex.practicum.filmorate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {
    private Integer id;
    private String email;
    private String login;
    private String name;
    private LocalDate birthday;
    private Set<Integer> friends = new HashSet<>();
}