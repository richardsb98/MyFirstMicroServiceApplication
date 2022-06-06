package com.tsi.richard.stanleybloom.program;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Service;


@Service
public interface ActorRepository extends CrudRepository<Actor,Integer> {

}
