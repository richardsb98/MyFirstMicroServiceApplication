package com.tsi.richard.stanleybloom.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;
import java.util.Optional;

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




    @BeforeEach
    public void setUp() {
        actorRepository = mock(ActorRepository.class);
        filmRepository = mock(FilmRepository.class);
        languageRepository = mock(LanguageRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        myfirstmicroserviceapplication = new MyFirstMicroserviceApplication(actorRepository, filmRepository, languageRepository, categoryRepository);
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



   @Test
    public void getallActors(){
        Actor testActor = new Actor("Kevin", "Hart", 208);
        testActor.setActor_id(208);
        when(actorRepository.findById(208)).thenReturn(Optional.of(testActor));
        Iterable<Actor> actual = myfirstmicroserviceapplication.getAllActors();
        Actor expected = testActor;
        Assertions.assertEquals(expected, actual, "Unable to get all actors");
   }


   @Test
    public void addAnActor(){
        Actor testActor = new Actor ("Ryan", "Reynolds", 209);
        testActor.setActor_id(209);
        Actor actual = myfirstmicroserviceapplication.addActor(testActor.getFirst_name(), testActor.getLast_name(), testActor.getActor_id()).;
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "The actor was not added");
   }



   @Test
    public void deleteActor(){
        Actor testActor = new Actor("actor", "test", 2);
        Optional<Actor> optionalactor = Optional.of(actor);
       Mockito.when(actorRepository.findById(2)).thenReturn(optionalactor);
       String actual = myfirstmicroserviceapplication.deleteActor(2);
       Mockito.verify(actorRepository).delete(actor);
       Assertions.assertEquals("Actor Deleted", actual, "Actor was not deleted");
   }
}
