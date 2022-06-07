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
    private ActorRepository actorrepository;


    @BeforeEach
    void setUp() {
        myfirstmicroserviceapplication = new MyFirstMicroserviceApplication(actorrepository);
    }

    @Test
    public void getAllActors() {

        myfirstmicroserviceapplication.getAllActors();
        verify(actorrepository).findAll();

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
