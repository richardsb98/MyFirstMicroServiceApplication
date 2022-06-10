package com.tsi.richard.stanleybloom.program;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MyFirstMicroserviceApplication myfirstmicroserviceapplication;
    @Mock
    private ActorRepository actorRepository;

    @Mock
    private FilmRepository filmRepository;

    @Mock
    private LanguageRepository languageRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private Film_CategoryRepository film_categoryRepository;



    @BeforeEach
    void setUp() {
        myfirstmicroserviceapplication = new MyFirstMicroserviceApplication(actorRepository, filmRepository, languageRepository, categoryRepository, film_categoryRepository);
    }

    @Test
    public void getAllActors() {

        myfirstmicroserviceapplication.getAllActors();
        verify(actorRepository).findAll();

    }

//    @Test
//    public void testAddActor(){
//        Actor savedActor = new Actor (first_name: "first_name", last_name: "last_name");
//
//        String expected = "Saved";
//
//        String Actual = myfirstmicroserviceapplication.addActor
//   }





}
