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
