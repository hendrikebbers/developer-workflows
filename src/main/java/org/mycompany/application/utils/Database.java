package org.mycompany.application.utils;

import org.mycompany.application.data.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class Database {

    private final EntityManagerFactory emf;
    private final EntityManager entityManager;

    public Database(final String jdbcUrl) {
        emf = Persistence.createEntityManagerFactory("database", Map.of("javax.persistence.jdbc.url", jdbcUrl));
        entityManager = emf.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<Person> loadAllPersons() {
            final Query q = entityManager.createQuery("select p from Person p");
        return q.getResultList();
    }

    public void insert(final Person person) {
        final EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(person);
            transaction.commit();
        } catch (final Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }
}
