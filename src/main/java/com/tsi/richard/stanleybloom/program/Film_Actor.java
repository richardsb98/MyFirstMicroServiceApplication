package com.tsi.richard.stanleybloom.program;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Table(name = "film_actor")
public class Film_Actor {


    @Entity
    class Actor {
        long actor_id;

        @ManyToMany
        @JoinTable(
                name = "film_actor",
                joinColumns = @JoinColumn(name = "actor_id"),
                inverseJoinColumns = @JoinColumn(name = "film_id"))
        Set<Actor> actors_films;


        public Actor(long actor_id, Set<Actor> films) {
            this.actor_id = actor_id;
            this.actors_films = films;
        }

        public long getActor_id() {
            return actor_id;
        }

        public void setActor_id(long actor_id) {
            this.actor_id = actor_id;
        }

        public Set<Actor> getFilms() {
            return actors_films;
        }

        public void setFilms(Set<Actor> films) {
            this.actors_films = films;
        }
    }


    @Entity
    class Film {
        @Id
        Long film_id;

        @ManyToMany(mappedBy = "films")
        Set<Film> filmactors;

        @ManyToMany
        @JoinTable(name = "film_actors_films",
                joinColumns = @JoinColumn(name = "film_1_film_id", referencedColumnName = "actors_films_2_film_id"))
        private Set<Film> films = new LinkedHashSet<>();

        public Set<Film> getFilms() {
            return films;
        }

        public void setFilms(Set<Film> films) {
            this.films = films;
        }

        public Film(Long film_id, Set<Film> actorsfilms) {
            this.film_id = film_id;
            this.filmactors = actorsfilms;
        }

        public Long getFilm_id() {
            return film_id;
        }

        public void setFilm_id(Long film_id) {
            this.film_id = film_id;
        }

        public Set<Film> getActorsfilms() {
            return filmactors;
        }

        public void setActorsfilms(Set<Film> actorsfilms) {
            this.filmactors = actorsfilms;
        }
    }






}
