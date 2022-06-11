package com.tsi.richard.stanleybloom.program;

import javax.persistence.*;

@Entity
@Table(name = "film_actor")
public class Film_Actor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int actor_id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int film_id;
}
