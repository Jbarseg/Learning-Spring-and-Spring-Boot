package com.jbarseg.hibernateConnection;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertOrder {
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
            Order order1 = new Order(new Date(2023, 02, 12));
            Order order2 = new Order(new Date(2023, 02, 12));
            Order order3 = new Order(new Date(2023, 02, 12));

            //Associate our databases
            client.addOrders(order1);
            client.addOrders(order2);
            client.addOrders(order3);
            mySession.save(order1);
            mySession.save(order2);
            mySession.save(order3);
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
