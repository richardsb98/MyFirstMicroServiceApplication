package com.tsi.richard.stanleybloom.program;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    public Category(){                                                      // Empty Constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)                     // Attributes
    int category_id;
    String name;

    @ManyToMany
            (fetch = FetchType.LAZY,
                    cascade = {
                            CascadeType.PERSIST,
                            CascadeType.MERGE
                    },
                    mappedBy = "actors")
    private Set<Film> films = new HashSet<>();



    public Category(int category_id, String name) {                         // Constructor
        this.category_id = category_id;
        this.name = name;
    }

    //////////////////////////////////// Getters and Setters ////////////////////////////////////
    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
