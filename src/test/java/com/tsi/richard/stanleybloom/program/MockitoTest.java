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
import org.springframework.test.web.servlet.ResultActions;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MyFirstMicroserviceApplication myfirstmicroserviceapplication;

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



    ////////////////////////////////////////////////////// Actor Tests //////////////////////////////////////////////////////
    @Test
    public void testgetAllActors() {
        myfirstmicroserviceapplication.getAllActors();
        verify(actorRepository).findAll();
    }

    @Test
    public void testgetActorByID(){
        Actor testActor = new Actor("Jack", "Dowitt", 4);
        Mockito.when(actorRepository.findById(testActor.getActor_id())).thenReturn(Optional.of(testActor));
        myfirstmicroserviceapplication.getActorByID(testActor.getActor_id());
    }

    @Test
    public void testgetActorByFirstName(){
        Actor testActor = new Actor("Hugh", "Jackman", 76);
        Mockito.when(actorRepository.findById(testActor.getActor_id())).thenReturn(Optional.of(testActor));
        myfirstmicroserviceapplication.getActorByFirstName(testActor.getFirst_name(), testActor.getLast_name(), testActor.getActor_id());
    }


   @Test
    public void testAddActor(){
        Actor testActor = new Actor ("Ryan", "Reynolds", 209);
        String expected = "New Actor Saved";
        String actual = myfirstmicroserviceapplication.addActor(testActor.getFirst_name(), testActor.getLast_name(), testActor.getActor_id());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Assertions.assertEquals(expected, actual, "The actor was not added to the database");
   }



   @Test
    public void testdeleteActor(){
        Actor testActor = new Actor();
        testActor.setFirst_name("Fred");
        testActor.setLast_name("Grayson");
        testActor.setActor_id(2);
        Mockito.lenient().when(actorRepository.findById(testActor.getActor_id())).thenReturn(Optional.of(testActor));
        myfirstmicroserviceapplication.deleteActor(testActor.getActor_id());
   }

    ////////////////////////////////////////////////////// Film Tests //////////////////////////////////////////////////////

}
