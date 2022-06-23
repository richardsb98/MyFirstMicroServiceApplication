package com.tsi.richard.stanleybloom.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;
import static org.springframework.http.RequestEntity.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        Actor testActor = new Actor("Jack", "Dowitt");
        Mockito.when(actorRepository.findById(testActor.getActor_id())).thenReturn(Optional.of(testActor));
        myfirstmicroserviceapplication.getActorByID(testActor.getActor_id());
    }

    @Test
    public void testgetActorByFirstName(){
        Actor testActor = new Actor("Hugh", "Jackman");
        Mockito.when(actorRepository.findById(testActor.getActor_id())).thenReturn(Optional.of(testActor));
        myfirstmicroserviceapplication.getActorByFirstName(testActor.getFirst_name(), testActor.getLast_name(), testActor.getActor_id());
    }


   @Test
    public void testAddActor(){
        Actor testActor = new Actor ("Ryan", "Reynolds");
        String expected = "New Actor Saved";
        String actual = myfirstmicroserviceapplication.addActor(testActor.getFirst_name(), testActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Assertions.assertEquals(expected, actual, "The actor was not added to the database");
   }

//    @Test
//    public void testPutExample() throws Exception {
//        Actor testActor = new Actor();
//        testActor.setActor_id(2);
//        testActor.setFirst_name("John");
//        Mockito.when(myfirstmicroserviceapplication.updateActor(testActor.getFirst_name(), testActor.getLast_name(), test).thenReturn(testActor);
//
//    }


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


    @Test
    public void testgetAllFilms() {
        myfirstmicroserviceapplication.getAllFilms();
        verify(filmRepository).findAll();
    }

    @Test
    public void testgetFilmByID(){
        Film testFilm = new Film(2, "Top Gun 2", 130, 2022, "R", 1);
        Mockito.lenient().when(filmRepository.findById(testFilm.getFilm_id())).thenReturn(Optional.of(testFilm));
        myfirstmicroserviceapplication.getActorByID(testFilm.getFilm_id());
    }

    @Test
    public void testfindFilmByID(){
        Film testFilm = new Film(66, "Top Gun 3", 130, 2050, "R", 1);
        Mockito.lenient().when(filmRepository.findById(testFilm.getFilm_id())).thenReturn(Optional.of(testFilm));
        myfirstmicroserviceapplication.getActorByID(testFilm.getFilm_id());
    }



    @Test
    public void testdeleteFilm(){
        Film testFilm = new Film();
        testFilm.setFilm_id(30);
        testFilm.setRating("PG-13");
        testFilm.setRelease_year(1998);
        testFilm.setTitle("Around the World in 80 Days");
        testFilm.setLanguage_id(1);
        testFilm.setLength(110);
        Mockito.lenient().when(filmRepository.findById(testFilm.getFilm_id())).thenReturn(Optional.of(testFilm));
        myfirstmicroserviceapplication.deleteFilmByID(testFilm.getFilm_id());
    }



    ////////////////////////////////////////////////////// Language Tests //////////////////////////////////////////////////////

    @Test
    public void testAllLanguages() {
        myfirstmicroserviceapplication.AllLanguages();
        verify(languageRepository).findAll();
    }

    @Test
    public void testgetLanguageByID(){
        Language testLanguage = new Language(1, "Celtic");
        Mockito.lenient().when(languageRepository.findById(testLanguage.getLanguage_id())).thenReturn(Optional.of(testLanguage));
        myfirstmicroserviceapplication.getActorByID(testLanguage.getLanguage_id());
    }

    @Test
    public void testdeleteLanguageByID(){
        Language testLanguage = new Language();
        testLanguage.setName("English");
        testLanguage.setLanguage_id(1);
        Mockito.lenient().when(languageRepository.findById(testLanguage.getLanguage_id())).thenReturn(Optional.of(testLanguage));
        myfirstmicroserviceapplication.deleteActor(testLanguage.getLanguage_id());
    }




    ////////////////////////////////////////////////////// Category Tests //////////////////////////////////////////////////////


    @Test
    public void testGetAllCategory() {
        myfirstmicroserviceapplication.getAllCategory();
        verify(categoryRepository).findAll();
    }

    @Test
    public void testgetcategoryByID(){
        Category testCategory = new Category(1, "Action");
        Mockito.lenient().when(categoryRepository.findById(testCategory.getCategory_id())).thenReturn(Optional.of(testCategory));
        myfirstmicroserviceapplication.getActorByID(testCategory.getCategory_id());
    }


    @Test
    public void testdeleteCategory(){
        Category testCategory = new Category();
        testCategory.setName("Horror");
        testCategory.setCategory_id(3);
        Mockito.lenient().when(categoryRepository.findById(testCategory.getCategory_id())).thenReturn(Optional.of(testCategory));
        myfirstmicroserviceapplication.deleteActor(testCategory.getCategory_id());
    }


}
