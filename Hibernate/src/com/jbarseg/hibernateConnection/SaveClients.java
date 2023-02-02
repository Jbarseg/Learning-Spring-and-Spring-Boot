package com.jbarseg.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveClients {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clients.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Clients client = new Clients("John", "Doe", "USA");
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
            System.out.println("Successfully inserted into your database");
            session.close();
        } finally {
            sessionFactory.close();
        }
    }
}
