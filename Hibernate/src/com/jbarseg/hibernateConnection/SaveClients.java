package com.jbarseg.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveClients {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Client client = new Client("Johnny", "Dorsey", "UK");
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
            System.out.println("Successfully inserted into your database");

            //Reading Data fromo our database

            session.beginTransaction();
            System.out.println("Reading our client with the id: " + client.getIdclient());
            Client insertedClient = session.get(Client.class, client.getIdclient());
            System.out.println("Client: " + insertedClient);
            session.getTransaction().commit();
            System.out.println("Successfully reading your database");
            session.close();



        } finally {
            sessionFactory.close();
        }
    }
}
