package com.payxpert.dao;

import java.util.List;
import com.payxpert.model.Payroll;

public interface PayrollDAO {
    void addPayroll(Payroll payroll);
    Payroll getPayrollById(int payrollId);
    List<Payroll> getPayrollsByEmployeeId(int employeeId);
    void updatePayroll(Payroll payroll);
    void deletePayroll(int payrollId);
}
