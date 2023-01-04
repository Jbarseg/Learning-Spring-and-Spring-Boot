package com.jbarseg.IoC;

public class SecretaryEmployee implements Employees {

    @Override
    public String getTasks() {
        return "Manage the agenda of the bosses";
    }

}
