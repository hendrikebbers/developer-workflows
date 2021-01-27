package org.mycompany.application.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mycompany.application.data.Person;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationUtilitiesTest {

    @Test
    public void testConvertForView1() {

        //given
        List<Person> l = List.of(new Person("Hendrik", "Ebbers"), new Person("Max", "Mustermann"));

        //when
        String readable = ApplicationUtilities.convertForView(l);

        //than
        Assertions.assertEquals("Hendrik Ebbers, Max Mustermann", readable);
    }

    @Test
    public void testConvertForView2() {

        //given
        List<Person> l = List.of();

        //when
        String readable = ApplicationUtilities.convertForView(l);

        //than
        Assertions.assertEquals("", readable);
    }

}
