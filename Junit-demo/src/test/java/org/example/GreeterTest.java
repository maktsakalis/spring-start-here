package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Calendar;

import static org.junit.Assert.*;

public class GreeterTest {

    @Test
    public void greetTest(){
        String greetings = Greeter.greet("Makis");

        Assert.assertNotNull(greetings);
        Assert.assertEquals(greetings,"Hello Makis");
    }
}