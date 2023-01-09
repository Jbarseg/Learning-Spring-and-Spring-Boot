package com.jbarseg.annotations;

import org.springframework.stereotype.Component;

@Component
public class FinancialReportTermIV implements FinancialReportCreation {

    @Override
    public String getFinancialReport() {
        // TODO Auto-generated method stub
        return "Presentation of the Final Financial Report of the Year";
    }
    
}
