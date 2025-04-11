package com.payxpert.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.payxpert.model.FinancialRecord;

import java.sql.Date;

public class FinancialRecordTest {

    private FinancialRecord financialRecord;

    @Before
    public void setUp() {
        financialRecord = new FinancialRecord();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(financialRecord);
    }

    @Test
    public void testParameterizedConstructor() {
        Date date = Date.valueOf("2025-04-08");
        FinancialRecord recordParam = new FinancialRecord(1, 101, date, "Salary Payment", 5000.0, "Credit");

        assertEquals(1, recordParam.getRecordId());
        assertEquals(101, recordParam.getEmployeeId());
        assertEquals(date, recordParam.getRecordDate());
        assertEquals("Salary Payment", recordParam.getDescription());
        assertEquals(5000.0, recordParam.getAmount(), 0.001);
        assertEquals("Credit", recordParam.getRecordType());
    }

    @Test
    public void testSetAndGetRecordId() {
        financialRecord.setRecordId(2);
        assertEquals(2, financialRecord.getRecordId());
    }

    @Test
    public void testSetAndGetEmployeeId() {
        financialRecord.setEmployeeId(202);
        assertEquals(202, financialRecord.getEmployeeId());
    }

    @Test
    public void testSetAndGetRecordDate() {
        Date date = Date.valueOf("2025-04-08");
        financialRecord.setRecordDate(date);
        assertEquals(date, financialRecord.getRecordDate());
    }

    @Test
    public void testSetAndGetDescription() {
        financialRecord.setDescription("Bonus Payment");
        assertEquals("Bonus Payment", financialRecord.getDescription());
    }

    @Test
    public void testSetAndGetAmount() {
        financialRecord.setAmount(750.50);
        assertEquals(750.50, financialRecord.getAmount(), 0.001);
    }

    @Test
    public void testSetAndGetRecordType() {
        financialRecord.setRecordType("Debit");
        assertEquals("Debit", financialRecord.getRecordType());
    }

    @Test
    public void testToString() {
        Date date = Date.valueOf("2025-04-08");
        financialRecord = new FinancialRecord(3, 303, date, "Project Bonus", 1200.0, "Credit");
        String expected = "FinancialRecord [recordId=3, employeeId=303, recordDate=" + date +
                          ", description=Project Bonus, amount=1200.0, recordType=Credit]";
        assertEquals(expected, financialRecord.toString());
    }
}
