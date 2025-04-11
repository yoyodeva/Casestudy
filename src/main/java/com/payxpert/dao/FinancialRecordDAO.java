package com.payxpert.dao;

import java.util.List;
import com.payxpert.model.FinancialRecord;

public interface FinancialRecordDAO {
    void addFinancialRecord(FinancialRecord financialRecord);
    FinancialRecord getFinancialRecordById(int recordId);
    List<FinancialRecord> getFinancialRecordsByEmployeeId(int employeeId);
    void updateFinancialRecord(FinancialRecord financialRecord);
    void deleteFinancialRecord(int recordId);
}
