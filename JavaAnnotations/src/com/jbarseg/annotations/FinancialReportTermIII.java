package com.jbarseg.annotations;

import org.springframework.stereotype.Component;

@Component
public class FinancialReportTermIII implements FinancialReportCreation {

    @Override
    public String getFinancialReport() {
        // TODO Auto-generated method stub
        return "Presentation of Favorable Financial Report for Quarter 3";
    }
    
}
