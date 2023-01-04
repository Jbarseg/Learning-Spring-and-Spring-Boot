package com.jbarseg.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseEmployees {
    public static void main(String[] args) {
        //Typical Way to create objects and use their methods
        Employees employee1 = new BossEmployee();
        Employees employee2 = new SecretaryEmployee();
        Employees employee3 = new ManagerEmployee();
        System.out.println(employee1.getTasks() + employee2.getTasks() + employee3.getTasks());

        //Using Spring

        //We load the XML file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Ask for the Bean
        Employees Jonathan = context.getBean("myEmployee", Employees.class);
        //Use the Bean
        System.out.println(Jonathan.getTasks);
        //Close the XML File
        context.close();
    }
}
