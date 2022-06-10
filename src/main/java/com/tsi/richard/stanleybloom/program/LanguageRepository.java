package com.tsi.richard.stanleybloom.program;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface LanguageRepository extends CrudRepository<Language, Integer> {
}
