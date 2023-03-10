package com.jbarseg.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseEmployees {
    public static void main(String[] args) {

        //Using Spring

        //We load the XML file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Ask for the Bean
        Employees Jonathan = context.getBean("myEmployee", Employees.class);
        SecretaryEmployee Maria = context.getBean("mySecretaryEmployee", SecretaryEmployee.class);
        //Use the Bean
        System.out.println(Jonathan.getTasks());

        //Use the bean for the Dependency Injection

        System.out.println(Jonathan.getReport());
        System.out.println(Maria.getReport());
        System.out.println(Maria.getEmail());
        System.out.println(Maria.getBusinessName());

        //Close the XML File
        context.close();
    }
}
