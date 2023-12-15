package ru.yandex.practicum.filmorate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exception.NotFoundException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.Genre;
import ru.yandex.practicum.filmorate.storage.filmGenre.GenreStorage;


import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreStorage genreStorage;

    public Genre getGenreById(long id) {
        try {
            return genreStorage.getGenreById(id);
        } catch (Exception e) {
            throw new NotFoundException(Film.class.getSimpleName(), id);
        }
    }

    public List<Genre> getAllGenre() {
        List<Genre> genres = genreStorage.getAllGenre();
        if (genres.isEmpty()) {
            throw new NotFoundException("Genres list is empty.");
        }
        return genres;
    }
}