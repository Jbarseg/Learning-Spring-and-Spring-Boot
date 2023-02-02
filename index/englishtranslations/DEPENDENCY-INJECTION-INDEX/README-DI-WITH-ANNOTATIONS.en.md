## Dependency Injection

**What is Dependency Injection (D.I)?** It is a design pattern that is often used in conjunction with IoC. Dependency injection involves creating objects in such a way that the amount of code required to create and configure those objects is minimized. Instead of a class creating its own dependencies, they are "injected" from the outside. _In short, dependency injection is a way to simplify the creation and configuration of objects in an application, allowing classes to focus on their business logic instead of worrying about creating their dependencies._

### **How to create a Dependency Injection with Constructors and Setters:**

**_1.Create the dependency class and interface_**

```

package com.jbarseg.annotations;

public interface FinancialReportCreation {
    public String getFinancialReport();
}


```
```

package com.jbarseg.annotations;

import org.springframework.stereotype.Component;

@Component
public class FinancialReportTermI implements FinancialReportCreation {


    @Override
    public String getFinancialReport() {
        // TODO Auto-generated method stub
        return "Presentation of Financial Report for Quarter I";
    }

}


```

**_2.Create the constructor or setter of the class we want to inject the dependency._**

**NOTE: To change our dependency we only have to change the name inside our @Qualifier**

```

package com.jbarseg.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ExperiencedTrader")
public class ExperiencedTrader implements Employees {

    private FinancialReportCreation newFinancialReport;

    /* Autowired with Constructors Dependency Injection
    @Autowired
    public ExperiencedTrader(FinancialReportCreation newFinancialReport) {
        this.newFinancialReport = newFinancialReport;
    } */

    //Autowired with Setter Dependency Injection

    @Autowired
    @Qualifier("financialReportTermIII")
    public void setNewFinancialReport(FinancialReportCreation newFinancialReport) {
        this.newFinancialReport = newFinancialReport;
    }

    @Override
    public String getTasks() {
        // TODO Auto-generated method stub
        return "Sell, sell and sell more!";
    }

    @Override
    public String getReport() {
        // TODO Auto-generated method stub
        return newFinancialReport.getFinancialReport();
    }

}


```

**_Create Objects and use them_**

```

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


```

