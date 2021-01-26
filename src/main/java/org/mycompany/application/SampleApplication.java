package org.mycompany.application;

import org.mycompany.application.data.Person;
import org.mycompany.application.utils.ApplicationUtilities;
import org.mycompany.application.utils.Database;

import java.util.List;

public class SampleApplication {

    public static void main(String[] args) {
        Database database = new Database();
        database.insert(new Person("Hendrik", "Ebbers", false));
        database.insert(new Person("Max", "Mustermann", true));

        final List<Person> allPersons = database.loadAllPersons();

        final String readable = ApplicationUtilities.convertForView(allPersons);
        System.out.println("All persons: " + readable);

        final List<Person> vips = ApplicationUtilities.getAllVips(allPersons);
        final String readableVips = ApplicationUtilities.convertForView(vips);
        System.out.println("All VIPs: " + readableVips);
    }
}
