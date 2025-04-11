package com.payxpert.service;

import com.payxpert.model.FinancialRecord;
import java.util.List;

public interface FinancialRecordService {
    void addFinancialRecord(FinancialRecord record);
    FinancialRecord getFinancialRecordById(int recordId);
    List<FinancialRecord> getFinancialRecordsByEmployeeId(int employeeId);
    void updateFinancialRecord(FinancialRecord record);
    void deleteFinancialRecord(int recordId);
}
