package com.jbarseg.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseDemoSinglePrototype {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        SecretaryEmployee John = context.getBean("mySecretaryEmployee", SecretaryEmployee.class);
        SecretaryEmployee Mary = context.getBean("mySecretaryEmployee", SecretaryEmployee.class);

        if (John == Mary) System.out.println("They point to the same object");
        else System.out.println("They don't point to the same object");


    }
}
