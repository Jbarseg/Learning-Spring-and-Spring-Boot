# Singleton and Prototype

**_Singleton:_** In Java, the Singleton design pattern is a design pattern that ensures that a class has only one instance, and provides a global point of access to that instance. The Singleton pattern is used to reduce the number of objects created, to decrease memory footprint and increase performance. In Spring, the Singleton design pattern is used to create singleton beans. A singleton bean is a bean that is created only once in the Spring container, and all requests for this bean will be served with the same instance.

**Example**

**Our Main class with Singleton**

```

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


```

**applicationContext2.xml with Singleton**

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

<!--Singleton-->

<bean id="mySecretaryEmployee" class = "com.jbarseg.IoC.SecretaryEmployee" lazy-init="true">

    <property name = "reportsCreator" ref="myReport"></property>

</bean>

</beans>

```

**_Prototype:_** In Java, the Prototype design pattern is a design pattern that allows you to create new objects by copying existing objects. The prototype pattern is used to create new objects by copying existing objects, rather than creating new objects from scratch. This can be useful when creating a new object is expensive or time-consuming, and you want to avoid this cost in the creation of new objects. In Spring, the Prototype design pattern is used to create prototype beans. A prototype bean is a bean that is created each time it is requested, rather than being a singleton bean that is created only once and shared.

**_To change to Prototype what we have to do is the next:_**

**To our bean we add the attribute scope = "prototype"**

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

<!--Singleton-->

<bean id="mySecretaryEmployee" class = "com.jbarseg.IoC.SecretaryEmployee" lazy-init="true" scope = "prototype">

    <property name = "reportsCreator" ref="myReport"></property>

</bean>

</beans>

```

Then if we print our Main Class, they don't scope to the same object