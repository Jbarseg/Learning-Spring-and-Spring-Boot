package com.jbarseg.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadClient {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Client.class)
                                        .addAnnotatedClass(ClientDetails.class)
                                        .buildSessionFactory();
        Session mySession = sessionFactory.openSession();


        try {
                //Associate our databases
                mySession.beginTransaction();
                ClientDetails clientDetails = mySession.get(ClientDetails.class,1);
                System.out.println(clientDetails);
                System.out.println(clientDetails.getClient());
                //Eliminar en cascada
                //mySession.delete(clientDetails)
                mySession.getTransaction().commit();
                System.out.println("Successful Transaction!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mySession.close(); //Si aca esta el .close no habra fuga de memoria, ya que si se cumple se corre el try, pero si no se cumple no correria el try y de igual manera cerraria la session
            sessionFactory.close();
        }

    }
}
