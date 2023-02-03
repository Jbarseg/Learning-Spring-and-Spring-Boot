package com.jbarseg.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateClients {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        //Database Update
        try {
            //int idClient = 1;
            session.beginTransaction();
            //Client client = session.get(Client.class, idClient);
            //client.setName("Clark");
            session.createQuery("update Client set lastname='Altman' where lastname LIKE 'D%'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Successfully update into your database");
            session.close();



        } finally {
            sessionFactory.close();
        }
    }
}
