package com.tsi.richard.stanleybloom.program;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actor_id;

    //Attributes
    String first_name;
    String last_name;



    @ManyToMany
            (fetch = FetchType.LAZY,
                    cascade = {
                            CascadeType.PERSIST,
                            CascadeType.MERGE
                    },
            mappedBy = "actors")
    private Set<Film> films = new HashSet<>();




    //Constructor
    public Actor(String first_name, String last_name, Integer actor_id) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.actor_id = actor_id;
    }


    public Actor() {                                    // empty constructor
    }

    //////////////////////////////////////////////////// Methods //////////////////////////////////////////////////////////////////////////////

    //getters and setters

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


}
