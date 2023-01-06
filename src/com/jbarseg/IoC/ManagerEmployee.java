package com.jbarseg.IoC;

public class ManagerEmployee implements Employees {

    private ReportsCreator reportsCreator;
    //Creation of the constructor of the class to inject the dependency
    public ManagerEmployee (ReportsCreator reportsCreator){
        this.reportsCreator = reportsCreator;
    }

    public ManagerEmployee() {
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
