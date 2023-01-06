# Spring and Spring Boot

## Starting with Spring

1.  To manage Spring you have to download all the available libraries in the following link: https://repo.spring.io/ui/native/release/org/springframework/spring/

## Content

## Inversion of Control

**What is inversion of control (IoC)?** Basically, instead of the application creating and controlling the objects it needs, IoC implies that the application delegates that responsibility to an external container. The container takes care of creating and managing the objects needed by the application, and then "injects" them where they are needed. _In short, IoC is a way to organize and manage an application's code more efficiently and flexibly, allowing for a higher degree of code reuse and maintainability._

**Steps to manage inversion of control (IoC):**

**_1. Config File:_** Create the config file of the Spring who is going to be in charge of create the containers and manage the objects needed by the application. Usually is an [applicationContext](https://github.com/Jbarseg/Learning-Spring-and-Spring-Boot/blob/master/applicationContext.xml) file.

_To create a new container:_

- Create a specific id for the new container.
- Call the specific object or class that you want to manage from here.

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

<bean id="myEmployee" class="com.jbarseg.IoC.ManagerEmployee">
</bean>
</beans>

```

**_2. Load XML file in our Main Class_**

```

ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

```

**_3. Ask for the Bean or our container:_** We have to specify the id of our container and the interface that is being implemented by all our classes.

```

Employees Jonathan = context.getBean("myEmployee", Employees.class)

```

**_4. Use the Bean and our new container_**

```

System.out.println(Jonathan.getTasks);

```

**_5. Close our config file_**

```

context.close();

```

**Important: If we want to manage other object, we dont have to create another object and call the method that we want, the only thing that we have to do is to change the object or the class that we want to manage in our XML file or [applicationContext](https://github.com/Jbarseg/Learning-Spring-and-Spring-Boot/blob/master/applicationContext.xml) file.**

## Dependency Injection

**What is Dependency Injection (D.I)?** It is a design pattern that is often used in conjunction with IoC. Dependency injection involves creating objects in such a way that the amount of code required to create and configure those objects is minimized. Instead of a class creating its own dependencies, they are "injected" from the outside. _In short, dependency injection is a way to simplify the creation and configuration of objects in an application, allowing classes to focus on their business logic instead of worrying about creating their dependencies._

**How to create a Dependency Injection with Constructors:**

**_1.Create the dependency class and interface_**

```

package com.jbarseg.IoC;

public interface ReportsCreator {
    //Create the dependency interface for the Dependency Injection

    public String getReport();

}

```
```

package com.jbarseg.IoC;

public class Reports implements ReportsCreator{
    //Create the dependency class for the Dependency Injection

    @Override
    public String getReport() {
        // TODO Auto-generated method stub
        return "This is the presentation of the report";
    }

}

```

**_2.Create the constructor of the class we want to inject the dependency._**

```

private ReportsCreator reportsCreator;
    //Creation of the constructor of the class to inject the dependency
    public ManagerEmployee (ReportsCreator reportsCreator){
        this.reportsCreator = reportsCreator;
    }

```

**_3.Configure dependency injection in our XML file_**

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
<bean id="myEmployee" class="com.jbarseg.IoC.ManagerEmployee">

<!--Container or Bean created for the Dependency Injection-->
<bean id="myReport" class="com.jbarseg.IoC.Reports"></bean>

<constructor-arg ref ="myReport"> </constructor-arg>


</bean>
</beans>

```

**How to create a Dependency Injection with Setters:**

**_1.Create the dependency class and interface_**

```

package com.jbarseg.IoC;

public interface ReportsCreator {
    //Create the dependency interface for the Dependency Injection

    public String getReport();

}

```
```

package com.jbarseg.IoC;

public class Reports implements ReportsCreator{
    //Create the dependency class for the Dependency Injection

    @Override
    public String getReport() {
        // TODO Auto-generated method stub
        return "This is the presentation of the report";
    }

}

```

**_2.Create the setter of the class we want to inject the dependency._**

```

private ReportsCreator reportsCreator;

    public void setReportsCreator(ReportsCreator reportsCreator) {
        this.reportsCreator = reportsCreator;
    }


```

**_3.Configure dependency injection in our XML file_**

```

<!--Container or Bean created for the Dependency Injection with Setters-->

<bean id="mySecretaryEmployee" class = "com.jbarseg.IoC.SecretaryEmployee" lazy-init="true">

    <property name = "reportsCreator" ref="myReport"></property>

</bean>

```