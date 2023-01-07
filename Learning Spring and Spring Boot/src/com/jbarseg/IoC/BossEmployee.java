package com.jbarseg.IoC;

public class BossEmployee implements Employees{
    public String getTasks(){
        // TODO Auto-generated method stub
        return "Managed issues related to my section employees";
    }

    @Override
    public String getReport() {
        // TODO Auto-generated method stub
        return null;
    }

}
