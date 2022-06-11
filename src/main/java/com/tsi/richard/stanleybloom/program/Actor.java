package com.tsi.richard.stanleybloom.program;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.*;
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



    //Constructor
    public Actor(String first_name, String last_name) {

        this.first_name = first_name;
        this.last_name = last_name;
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
