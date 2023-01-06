package com.jbarseg.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CycleLifeBean {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Employees Johmny = context.getBean("myEmployee", Employees.class);
        System.out.println(Johmny.getReport());
        context.close();
    }
}
