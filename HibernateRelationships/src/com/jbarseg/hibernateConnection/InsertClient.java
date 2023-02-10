package com.jbarseg.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertClient {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Client.class)
                                        .addAnnotatedClass(ClientDetails.class)
                                        .buildSessionFactory();
        Session mySession = sessionFactory.openSession();


        try {
            Client client = new Client("John", "Spyke", "UK");
            ClientDetails clientDetails = new ClientDetails("www.spyke.com", "86754637", "Say hi to the details");
            //Associate our databases
            client.setClientDetails(clientDetails);
            mySession.beginTransaction();
            mySession.save(client);
            mySession.getTransaction().commit();
            System.out.println("Successful Transaction!");

        } finally {
            sessionFactory.close();

        }

    }
}
