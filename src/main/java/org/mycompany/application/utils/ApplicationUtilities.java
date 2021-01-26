package org.mycompany.application.utils;

import org.mycompany.application.data.Person;

import java.util.List;
import java.util.stream.Collectors;

public class ApplicationUtilities {

    /**
     * This methods returns a human readable and ',' seperated string that contains all persons of the given list.
     * @param persons the list of persons
     * @return the human readable string
     */
    public final static String convertForView(final List<Person> persons) {
        final StringBuilder result = new StringBuilder();
        persons.forEach(person -> {
            result.append(person.getFirstName());
            result.append(" ");
            result.append(person.getLastName());
            result.append(", ");
        });
        return result.substring(0, result.length() - 2);
    }

    /**
     * This methods returns a list that contains all VIPs from the given person list
     * @param persons the persons
     * @return the list with all VIPs
     */
    public final static List<Person> getAllVips(final List<Person> persons) {
        return persons.stream()
                .filter(person -> person.isVip())
                .collect(Collectors.toList());
    }
}
