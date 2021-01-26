package org.mycompany.application.utils;

import org.hibernate.hql.internal.ast.ParseErrorHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mycompany.application.data.Person;

import javax.swing.plaf.ViewportUI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationUtilitiesTest {

    @Test
    @DisplayName("A simple dummy test")
    public void testDummy() {
        System.out.println("HUHU");
    }

    @Test
    @DisplayName("Test readable string for 1 person")
    public void testConvertForView() {
        //given
        final List<Person> persons = List.of(new Person("Hendrik", "Ebbers"));

        //when
        final String readable = ApplicationUtilities.convertForView(persons);

        //than
        Assertions.assertEquals("Hendrik Ebbers", readable);
    }

    @Test
    @DisplayName("Test readable string for 2 person")
    public void testConvertForView2() {
        //given
        final List<Person> persons = List.of(new Person("Hendrik", "Ebbers"), new Person("Max", "Mustermann"));

        //when
        final String readable = ApplicationUtilities.convertForView(persons);

        //than
        Assertions.assertEquals("Hendrik Ebbers, Max Mustermann", readable);
    }

}
