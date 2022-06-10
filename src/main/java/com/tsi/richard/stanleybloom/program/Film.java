package com.tsi.richard.stanleybloom.program;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.time.Year;
import java.util.Optional;

@Entity
@Table(name = "film")
public class Film {

    //////////////////////////////// Attributes ////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int film_id;

    String title;
    int length;
    int release_year;
    String rating;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int language_id;

    //////////////////////////////// Constructor ////////////////////////////////

    public Film() {                                 // empty constructor
    }

    public Film(int film_id, String title, int length, int release_year, String rating, int language_id) {
        this.film_id = film_id;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }
}