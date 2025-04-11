package com.payxpert.model;

import java.sql.Date;
import java.time.LocalDate;

public class Payroll {
    private int payrollId;
    private int employeeId;
    private double basicSalary;
    private double allowances;
    private double deductions;
    private double netSalary;
    private Date payDate;

    public Payroll() {}

    public Payroll(int payrollId, int employeeId, double basicSalary, double allowances, double deductions, double netSalary, Date payDate) {
        this.payrollId = payrollId;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.deductions = deductions;
        this.netSalary = netSalary;
        this.payDate = payDate;
    }

    public int getPayrollId() { return payrollId; }
    public void setPayrollId(int payrollId) { this.payrollId = payrollId; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public double getAllowances() { return allowances; }
    public void setAllowances(double allowances) { this.allowances = allowances; }

    public double getDeductions() { return deductions; }
    public void setDeductions(double deductions) { this.deductions = deductions; }

    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }

    public Date getPayDate() { return payDate; }

    public void setPayDate(LocalDate payDate) {
        this.payDate = Date.valueOf(payDate);
    }

    
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "Payroll [payrollId=" + payrollId + ", employeeId=" + employeeId + ", basicSalary=" + basicSalary +
               ", allowances=" + allowances + ", deductions=" + deductions + ", netSalary=" + netSalary + ", payDate=" + payDate + "]";
    }
}
