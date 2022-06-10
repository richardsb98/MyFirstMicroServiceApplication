package com.tsi.richard.stanleybloom.program;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.time.Year;
import java.util.Optional;

@Entity

public class Film {

    //////////////////////////////// Attributes ////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int film_id;

    int length;
    Year release_year;
    Enum rating;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int language_id;

    //////////////////////////////// Constructor ////////////////////////////////

    public Film() {                                 // empty constructor
    }

    public Film(int film_id, int length, Year release_year, Enum rating, int language_id) {
        this.film_id = film_id;
        this.length = length;
        this.release_year = release_year;
        this.rating = rating;
        this.language_id = language_id;
    }

    //////////////////////////////// Getters and Setters ////////////////////////////////

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Year getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Year release_year) {
        this.release_year = release_year;
    }

    public Enum getRating() {
        return rating;
    }

    public void setRating(Enum rating) {
        this.rating = rating;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }
}