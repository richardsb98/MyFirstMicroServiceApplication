package com.tsi.richard.stanleybloom.program;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class ActorTest extends Actor {

    Actor testActor = new Actor (first_name: "first_name", last_name: "last_name");

    @Test
    public void testActor(){
        Assertions.assertEquals(expected: "name", testActor.getFirst_name(), message: "name is not initialised");
    }


}
