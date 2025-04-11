package com.payxpert.dao;

import java.util.List;
import com.payxpert.model.Tax;

public interface TaxDAO {
    void addTax(Tax tax);
    Tax getTaxById(int taxId);
    List<Tax> getTaxesByEmployeeId(int employeeId);
    void updateTax(Tax tax);
    void deleteTax(int taxId);
}
