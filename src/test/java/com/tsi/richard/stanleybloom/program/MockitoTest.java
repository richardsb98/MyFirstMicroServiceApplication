package com.tsi.richard.stanleybloom.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MyFirstMicroserviceApplication myfirstmicroserviceapplication;

    @InjectMocks
    private Actor actor;

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
    public void setUp() {
        actorRepository = mock(ActorRepository.class);
        filmRepository = mock(FilmRepository.class);
        languageRepository = mock(LanguageRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        film_categoryRepository = mock(Film_CategoryRepository.class);
        myfirstmicroserviceapplication = new MyFirstMicroserviceApplication(actorRepository, filmRepository, languageRepository, categoryRepository, film_categoryRepository);
    }

    @Test
    public void getAllActors() {
        myfirstmicroserviceapplication.getAllActors();
        verify(actorRepository).findAll();

    }

    @Test
    public void testAddActor(){
        Actor savedActor = new Actor ("first_name", "last_name", 1);
        String Expected = "Saved";
        String Actual = myfirstmicroserviceapplication.addActor(savedActor.getFirst_name(),savedActor.getLast_name(), savedActor.getActor_id());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Assertions.assertEquals(Expected, Actual, "Actor data not saved");
   }





}
