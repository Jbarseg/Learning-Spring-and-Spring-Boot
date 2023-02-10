package com.jbarseg.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDetailsClient {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Client.class)
                                        .addAnnotatedClass(ClientDetails.class)
                                        .buildSessionFactory();
        Session mySession = sessionFactory.openSession();


        try {
            //Associate our databases
            mySession.beginTransaction();
            ClientDetails clientDetails = mySession.get(ClientDetails.class, 2);

            if(clientDetails != null){
                mySession.delete(clientDetails);
            }

            mySession.getTransaction().commit();
            System.out.println("Successful Transaction!");

        } finally {
            sessionFactory.close();

        }
    }
}
