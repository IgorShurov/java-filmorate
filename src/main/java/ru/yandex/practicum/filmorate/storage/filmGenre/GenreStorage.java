package ru.yandex.practicum.filmorate.storage.filmGenre;

import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.Genre;

import java.util.List;

public interface GenreStorage {

    Genre getGenreById(long id);

    List<Genre> getAllGenre();

    void createFilmGenre(Film film);

    void deleteFilmGenre(Film film);

    List<Film> setGenres(List<Film> films);

    Film setGenre(Film film);
}