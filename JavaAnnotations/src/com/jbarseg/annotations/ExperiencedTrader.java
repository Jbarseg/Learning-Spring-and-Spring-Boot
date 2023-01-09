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
