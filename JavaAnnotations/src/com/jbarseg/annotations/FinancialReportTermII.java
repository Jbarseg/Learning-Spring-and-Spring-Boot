package com.jbarseg.annotations;

import org.springframework.stereotype.Component;

@Component
public class FinancialReportTermII implements FinancialReportCreation {

    @Override
    public String getFinancialReport() {
        // TODO Auto-generated method stub
        return "Presentation of Catastrophic Financial Report for Quarter 2";
    }

}
