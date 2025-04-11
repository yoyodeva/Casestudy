package com.payxpert.service;

import com.payxpert.dao.impl.FinancialRecordDAOImpl;
import com.payxpert.model.FinancialRecord;
import java.util.List;

public class FinancialRecordServiceImpl implements FinancialRecordService {
    private FinancialRecordDAOImpl financialRecordDAO;

    public FinancialRecordServiceImpl() {
        this.financialRecordDAO = new FinancialRecordDAOImpl();
    }

    

	@Override
    public void addFinancialRecord(FinancialRecord record) {
        financialRecordDAO.addFinancialRecord(record);
    }

    @Override
    public FinancialRecord getFinancialRecordById(int recordId) {
        return financialRecordDAO.getFinancialRecordById(recordId);
    }

    @Override
    public List<FinancialRecord> getFinancialRecordsByEmployeeId(int employeeId) {
        return financialRecordDAO.getFinancialRecordsByEmployeeId(employeeId);
    }

    @Override
    public void updateFinancialRecord(FinancialRecord record) {
        financialRecordDAO.updateFinancialRecord(record);
    }

    @Override
    public void deleteFinancialRecord(int recordId) {
        financialRecordDAO.deleteFinancialRecord(recordId);
    }
}
