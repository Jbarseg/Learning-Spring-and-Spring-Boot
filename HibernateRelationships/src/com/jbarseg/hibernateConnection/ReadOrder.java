package com.jbarseg.hibernateConnection;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadOrder {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Client.class)
                                        .addAnnotatedClass(ClientDetails.class)
                                        .addAnnotatedClass(Order.class)
                                        .buildSessionFactory();
        Session mySession = sessionFactory.openSession();


        try {
            mySession.beginTransaction();

            Client client = mySession.get(Client.class, 1);
            System.out.println(client.getOrders());
            mySession.getTransaction().commit();
            System.out.println("Successful Transaction!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mySession.close();
            sessionFactory.close();

        }

    }
}
