package com.jbarseg.hibernateConnection;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryClients {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            //"from Client cl where cl.lastname=''""
            //"from Client"

            List<Client> clients = session.createQuery("from Client").getResultList(); 

            for(Client client:clients){
                System.out.println(clients);
            }


            clients = session.createQuery("from Client cl where cl.lastname='Dorsey'").getResultList(); 

            for(Client client:clients){
                System.out.println(clients);
            }

            clients = session.createQuery("from Client cl where cl.lastname='Dorsey'" + " or cl.location='USA'").getResultList(); 

            for(Client client:clients){
                System.out.println(clients);
            }

            session.getTransaction().commit();
            session.close();

        } finally {

        }
    }
}
