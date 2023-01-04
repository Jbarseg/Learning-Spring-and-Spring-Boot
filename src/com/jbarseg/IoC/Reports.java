package com.jbarseg.IoC;

public class Reports implements ReportsCreator{
    //Create the dependency class for the Dependency Injection

    @Override
    public String getReport() {
        // TODO Auto-generated method stub
        return "This is the presentation of the report";
    }

}
