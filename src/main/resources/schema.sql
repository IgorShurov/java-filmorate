DROP TABLE IF EXISTS
    mpa,
    genre,
    films,
    film_genre,
    users,
    film_likes,
    friends;

CREATE TABLE IF NOT EXISTS mpa
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name        varchar NOT NULL UNIQUE,
    description varchar NOT NULL
);

CREATE TABLE IF NOT EXISTS genre
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS films
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name         varchar(200) NOT NULL,
    description  varchar(200) NOT NULL,
    release_date date         NOT NULL,
    duration     INTEGER      NOT NULL,
    mpa_id       BIGINT REFERENCES mpa (id)
);

CREATE TABLE IF NOT EXISTS film_genre
(
    genre_id BIGINT REFERENCES genre (id) ON DELETE RESTRICT,
    film_id  BIGINT REFERENCES films (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS users
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    email    varchar NOT NULL UNIQUE,
    login    varchar NOT NULL UNIQUE,
    name     varchar NOT NULL,
    birthday date    NOT NULL
);

CREATE TABLE IF NOT EXISTS film_likes
(
    user_id BIGINT UNIQUE REFERENCES users (id) ON DELETE CASCADE,
    film_id BIGINT UNIQUE REFERENCES films (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS friends
(
    user_id   BIGINT REFERENCES users (id) ON DELETE CASCADE,
    friend_id BIGINT REFERENCES users (id) ON DELETE CASCADE,
    status    boolean DEFAULT false
);