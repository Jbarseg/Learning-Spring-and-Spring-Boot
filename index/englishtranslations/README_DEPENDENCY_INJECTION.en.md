## Dependency Injection

**What is Dependency Injection (D.I)?** It is a design pattern that is often used in conjunction with IoC. Dependency injection involves creating objects in such a way that the amount of code required to create and configure those objects is minimized. Instead of a class creating its own dependencies, they are "injected" from the outside. _In short, dependency injection is a way to simplify the creation and configuration of objects in an application, allowing classes to focus on their business logic instead of worrying about creating their dependencies._

### **How to create a Dependency Injection with Constructors:**

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
<bean id="myReport" class="com.jbarseg.IoC.Reports"></bean>

<!--Container or Bean created for the Dependency Injection with Constructors-->

<bean id="myEmployee" class="com.jbarseg.IoC.ManagerEmployee">

    <constructor-arg ref ="myReport"> </constructor-arg>

</bean>
</beans>

```

### **How to create a Dependency Injection with Setters:**

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

<bean id="mySecretaryEmployee" class="com.jbarseg.IoC.SecretaryEmployee">

    <property name = "reportsCreator" ref="myReport"></property>

</bean>

```
### **How to create a Dependency Injection with Fields:**

**_1.Create the fields or variables that you want to control_**

```

public class SecretaryEmployee implements Employees {

    //We are going to use this class to explain the second method to own to do the Dependency Injection
    //We have to create the setter of the variable reportsCreator

    private String email;
    private String businessName;

}

```

**_2.Create the getters and setters of this fields or variables_**

```

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }


```

**_3.Add more properties to your XML Bean_**

```

<bean id="mySecretaryEmployee" class = "com.jbarseg.IoC.SecretaryEmployee" lazy-init="true">

    <property name = "reportsCreator" ref="myReport"></property>
    <!--Properties created for the Dependency Injection with Fields-->
    <property name = "email" value="jhonnyd08@kopsy.com"></property>
    <property name = "businessName" value="Kopsy"></property>

</bean>

```