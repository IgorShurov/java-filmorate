package ru.yandex.practicum.filmorate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exception.NotFoundException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.Mpa;
import ru.yandex.practicum.filmorate.storage.filmMpa.MpaStorage;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MpaService {
    private final MpaStorage mpaStorage;

    public Mpa getMpaById(long id) {
        try {
            return mpaStorage.getMpaById(id);
        } catch (Exception e) {
            throw new NotFoundException(Film.class.getSimpleName(), id);
        }
    }

    public List<Mpa> getAllMpa() {
        List<Mpa> mpas = mpaStorage.getAllMpa()
                .stream()
                .sorted(Comparator.comparingLong(Mpa::getId))
                .collect(Collectors.toList());
        if (mpas.isEmpty()) {
            throw new NotFoundException("Mpa list is empty.");
        }
        return mpas;
    }
}