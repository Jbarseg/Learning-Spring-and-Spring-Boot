package com.jbarseg.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseAnnotations {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employees Johnny = context.getBean("ExperiencedTrader", Employees.class);
        Employees Mary = context.getBean("ExperiencedTrader", Employees.class);

        System.out.println(Johnny.getTasks());
        System.out.println(Johnny.getReport());

        //Using @Scope Annotation

        if (Johnny == Mary) System.out.println("They scope to the same object. Singleton.");
        else System.out.println("They don't scope to the same object. Prototype");

        context.close();

    }
}
