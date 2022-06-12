package com.tsi.richard.stanleybloom.program;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Repository
@Service
public interface ActorRepository extends CrudRepository<Actor,Integer>{



}




