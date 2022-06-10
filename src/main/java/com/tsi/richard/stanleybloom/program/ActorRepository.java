package com.tsi.richard.stanleybloom.program;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ActorRepository extends CrudRepository<Actor,Integer>{

}




