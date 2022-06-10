package com.tsi.richard.stanleybloom.program;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActorTest {

    Actor testActor = new Actor();

    @Test
    void testActor(){
        Assertions.assertEquals(first_name, testActor.getFirst_name(), "first_name is not initialised");
        Assertions.assertEquals(last_name, testActor.getLast_name(), "last_name is not initialised");

    }


}
