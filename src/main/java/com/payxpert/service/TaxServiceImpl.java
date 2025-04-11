package com.payxpert.service;

import com.payxpert.dao.impl.TaxDAOImpl;
import com.payxpert.model.Tax;
import java.util.List;

public class TaxServiceImpl implements TaxService {
    private TaxDAOImpl taxDAO;

    public TaxServiceImpl() {
        this.taxDAO = new TaxDAOImpl();
    }

    @Override
    public void addTax(Tax tax) {
        taxDAO.addTax(tax);
    }

    @Override
    public Tax getTaxById(int taxId) {
        return taxDAO.getTaxById(taxId);
    }

    @Override
    public List<Tax> getTaxesByEmployeeId(int employeeId) {
        return taxDAO.getTaxesByEmployeeId(employeeId);
    }

    @Override
    public void updateTax(Tax tax) {
        taxDAO.updateTax(tax);
    }

    @Override
    public void deleteTax(int taxId) {
        taxDAO.deleteTax(taxId);
    }

    
}
