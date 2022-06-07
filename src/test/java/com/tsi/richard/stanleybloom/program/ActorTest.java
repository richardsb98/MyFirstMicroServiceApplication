package com.tsi.richard.stanleybloom.program;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest extends Actor {

    Actor testActor = new Actor ("first name", "last name");
    @Test
    public void testActor(){
        assertEquals("error", "first_name", "");
    }


}
