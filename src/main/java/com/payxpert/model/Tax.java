package com.payxpert.model;

public class Tax {
    private int taxId;
    private int employeeId;
    private double taxAmount;
    private int taxYear;

   
    public Tax() {}

    public Tax(int taxId, int employeeId, double taxAmount, int taxYear) {
        this.taxId = taxId;
        this.employeeId = employeeId;
        this.taxAmount = taxAmount;
        this.taxYear = taxYear;
    }

    
    public int getTaxId() {
        return taxId;
       
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public int getTaxYear() {
        return taxYear;
    }

    public void setTaxYear(int taxYear) {
        this.taxYear = taxYear;
    }

   
    @Override
    public String toString() {
        return "Tax [taxId=" + taxId + ", employeeId=" + employeeId + ", taxAmount=" + taxAmount +
               ", taxYear=" + taxYear + "]";
    }
}
