package com.tsi.richard.stanleybloom.program;

import javax.persistence.*;

@Entity
@Table(name = "language")
public class Language {

    public Language() {                                 // empty constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int language_id;
    String name;



    public Language(int language_id, String name) {                                 // Constructor
        this.language_id = language_id;
        this.name = name;
    }

    //////////////////////////////////////////////////// Getters and Setters //////////////////////////////////////////////////////////////////////////////

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
