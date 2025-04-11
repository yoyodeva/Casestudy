package com.payxpert.service;

import com.payxpert.model.Payroll;
import com.payxpert.model.Tax;
import java.util.List;

public interface TaxService {
    void addTax(Tax tax);
    Tax getTaxById(int taxId);
    List<Tax> getTaxesByEmployeeId(int employeeId);
    void updateTax(Tax tax);
    void deleteTax(int taxId);

}
