package com.payxpert.service;

import com.payxpert.dao.PayrollDAO;
import com.payxpert.model.Payroll;
import java.util.List;

public class PayrollServiceImpl implements PayrollService {

    private PayrollDAO payrollDAO;

    public PayrollServiceImpl(PayrollDAO payrollDAO) {
        this.payrollDAO = payrollDAO;
    }

    @Override
    public void addPayroll(Payroll payroll) {
        calculateNetSalary(payroll);   
        payrollDAO.addPayroll(payroll);
    }

    @Override
    public Payroll getPayrollById(int payrollId) {
        return payrollDAO.getPayrollById(payrollId);
    }

    @Override
    public List<Payroll> getPayrollsByEmployeeId(int employeeId) {
        return payrollDAO.getPayrollsByEmployeeId(employeeId);
    }

    @Override
    public void updatePayroll(Payroll payroll) {
        calculateNetSalary(payroll);   
        payrollDAO.updatePayroll(payroll);
    }

    @Override
    public void deletePayroll(int payrollId) {
        payrollDAO.deletePayroll(payrollId);
    }

    
    private void calculateNetSalary(Payroll payroll) {
        double netSalary = payroll.getBasicSalary() + payroll.getAllowances() - payroll.getDeductions();
        payroll.setNetSalary(netSalary);
    }
}
