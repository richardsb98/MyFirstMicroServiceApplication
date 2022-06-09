package com.tsi.richard.stanleybloom.program;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface NameRepository extends Repository<Actor,Long> {

    static List<Actor> findByLastName(String lastname) {
        return null;
    }
}
