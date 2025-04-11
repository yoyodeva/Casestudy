package com.payxpert.service;

import com.payxpert.model.Payroll;
import java.util.List;

public interface PayrollService {
    void addPayroll(Payroll payroll);
    Payroll getPayrollById(int payrollId);
    List<Payroll> getPayrollsByEmployeeId(int employeeId);
    void updatePayroll(Payroll payroll);
    void deletePayroll(int payrollId);
	
}
