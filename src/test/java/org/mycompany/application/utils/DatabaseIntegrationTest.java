package org.mycompany.application.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mycompany.application.data.Person;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@Testcontainers
public class DatabaseIntegrationTest {


    @Container
    private final PostgreSQLContainer container = new PostgreSQLContainer("postgres:9.6.12")
            .withDatabaseName("database")
            .withUsername("root")
            .withPassword("root");

    @Test
    void testLoadData() {
        Database database = new Database(container.getJdbcUrl());
        database.insert(new Person("Hendrik", "Ebbers", false));
        database.insert(new Person("Max", "Mustermann", true));

        final List<Person> allPersons = database.loadAllPersons();
        final String readable = ApplicationUtilities.convertForView(allPersons);
        Assertions.assertEquals("Hendrik Ebbers, Max Mustermann", readable);
    }
}
