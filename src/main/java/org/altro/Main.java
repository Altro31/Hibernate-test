package org.altro;

import jakarta.persistence.*;
import org.altro.schema.Author;
import org.altro.schema.Book;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        setup();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try (entityManager) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(new Author("Altro", 21));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public static void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.altro");
    }
}