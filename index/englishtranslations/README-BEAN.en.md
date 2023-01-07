# Beans

## **_What is a Bean?_**

**Bean:** In the Spring framework, a bean is an object that is managed by the Spring IoC (Inversion of Control) container. The purpose of the Spring IoC container is to instantiate, configure, and assemble the beans that make up an application. You can define a bean in a Spring configuration file, which can be written in XML, Java, or a combination of the two. A bean definition includes information about the class of the object, any dependencies that the object has, and how the object should be configured. When the Spring IoC container is asked to create the bean, it will use the bean definition to create the object and wire its dependencies together.

## **_Cycle Life Bean_**

### Init and Destroy Methods

***Init Method:*** The init-method attribute is used to specify a method that should be called after a bean has been instantiated and all of its dependencies have been injected. This method can be used to perform any initialization tasks that are required by the bean, such as setting up resources or performing other required setup tasks. The init-method attribute is specified in the bean definition, and the specified method will be called automatically by the Spring IoC container after the bean has been created. This allows you to centralize the initialization logic for a bean in a single place, rather than scattering it throughout your application code.

***Destroy Method:*** The destroy-method attribute is used to specify a method that should be called when a bean is being destroyed by the Spring IoC container. This can be used to perform any cleanup tasks that are required, such as closing open resources or performing other required cleanup tasks. The destroy-method attribute is specified in the bean definition, and the specified method will be called automatically by the Spring IoC container when the bean is being destroyed. This allows you to centralize the cleanup logic for a bean in a single place, rather than scattering it throughout your application code. It's important to note that the destroy-method attribute is only applicable to beans that are created and managed by the Spring IoC container. If you create a bean programmatically, you will need to handle its cleanup yourself.

*Example of Init and Destroy Methods:*

**Main Class**

```

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

```

**Creation of the Init and Destroy Methods**
*Important: This method has to be created in the class where we have the dependency*

```

public class ManagerEmployee implements Employees {

    private ReportsCreator reportsCreator;
    //Creation of the constructor of the class to inject the dependency
    public ManagerEmployee (ReportsCreator reportsCreator){
        this.reportsCreator = reportsCreator;
    }

    public ManagerEmployee() {
    }

    public void initMethod(){
        System.out.println("Init Method");
    }

    public void destroyMethod(){
        System.out.println("Destroy Method");
    }

    @Override
    public String getTasks() {
        // TODO Auto-generated method stub
        return "Manage the staff";
    }
    @Override
    public String getReport() {
        // TODO Auto-generated method stub
        return "Report created by the Manager: " + reportsCreator.getReport();
    }
}


```

**XML File**

```

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
    http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.1.xsd
">
<!--Container or Bean created for the Inversion of Control-->
<bean id="myReport" class="com.jbarseg.IoC.Reports"></bean>

<!--Container or Bean created for the Dependency Injection with Constructors-->
<!--Testing init and destroy methods-->

<bean id="myEmployee" class="com.jbarseg.IoC.ManagerEmployee"
    init-method="initMethod"
    destroy-method="destroyMethod">
    <constructor-arg ref="myReport"/>
</bean>

</beans>

```