package com.tsi.richard.stanleybloom.program;


import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitTests {


    Actor testActor = new Actor("first_name", "last_name");
    @Test
    public void testActor(){
        Assertions.assertEquals("first_name", testActor.getFirst_name(), "first_name is not initialised");
        Assertions.assertEquals("last_name", testActor.getLast_name(), "last_name is not initialised");
    }



    Film testFilm = new Film(2, "title", 130, 2010, "PG", 2);
    @Test
    public void testFilm(){
        Assertions.assertEquals(2, testFilm.getFilm_id(), "film ID is not initialised");
        Assertions.assertEquals("title", testFilm.getTitle(), "title is not initialised");
        Assertions.assertEquals(130, testFilm.getLength(), "length is not initialised");
        Assertions.assertEquals(2010, testFilm.getRelease_year(), "release year is not initialised");
        Assertions.assertEquals("PG", testFilm.getRating(), "rating is not initialised");
        Assertions.assertEquals(2, testFilm.getLanguage_id(), "language ID is not initialised");
    }



    Category testCategory = new Category(1, "name");
    @Test
    public void testCategory() {
        Assertions.assertEquals(1, testCategory.getCategory_id(), "category ID is not initialised");
        Assertions.assertEquals("name", testCategory.getName(), "name is not initialised");
    }



    Language testLanguage = new Language(1, "name");
    @Test
    public void testLanguage() {
        Assertions.assertEquals(1, testLanguage.getLanguage_id(), "language ID is not initialised");
        Assertions.assertEquals("name", testLanguage.getName(), "name is not initialised");
    }





}

