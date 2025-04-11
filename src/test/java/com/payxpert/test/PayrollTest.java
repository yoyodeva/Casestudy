package com.payxpert.test;

import static org.junit.Assert.*;
import java.sql.Date;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import com.payxpert.model.Payroll;

public class PayrollTest {

    private Payroll payroll;

    @Before
    public void setUp() {
        payroll = new Payroll();
    }

    @Test
    public void testSetAndGetPayrollId() {
        payroll.setPayrollId(101);
        assertEquals(101, payroll.getPayrollId());
    }

    @Test
    public void testSetAndGetEmployeeId() {
        payroll.setEmployeeId(501);
        assertEquals(501, payroll.getEmployeeId());
    }

    @Test
    public void testSetAndGetBasicSalary() {
        payroll.setBasicSalary(50000.00);
        assertEquals(50000.00, payroll.getBasicSalary(), 0.001);
    }

    @Test
    public void testSetAndGetAllowances() {
        payroll.setAllowances(5000.00);
        assertEquals(5000.00, payroll.getAllowances(), 0.001);
    }

    @Test
    public void testSetAndGetDeductions() {
        payroll.setDeductions(2000.00);
        assertEquals(2000.00, payroll.getDeductions(), 0.001);
    }

    @Test
    public void testSetAndGetNetSalary() {
        payroll.setNetSalary(53000.00);
        assertEquals(53000.00, payroll.getNetSalary(), 0.001);
    }

    @Test
    public void testSetAndGetPayDateUsingDate() {
        Date payDate = Date.valueOf("2025-04-08");
        payroll.setPayDate(payDate);
        assertEquals(payDate, payroll.getPayDate());
    }

    @Test
    public void testSetAndGetPayDateUsingLocalDate() {
        LocalDate localDate = LocalDate.of(2025, 4, 8);
        payroll.setPayDate(localDate);
        assertEquals(Date.valueOf(localDate), payroll.getPayDate());
    }

    @Test
    public void testPayrollConstructor() {
        Date payDate = Date.valueOf("2025-04-08");
        Payroll newPayroll = new Payroll(102, 502, 60000.00, 4000.00, 3000.00, 61000.00, payDate);

        assertEquals(102, newPayroll.getPayrollId());
        assertEquals(502, newPayroll.getEmployeeId());
        assertEquals(60000.00, newPayroll.getBasicSalary(), 0.001);
        assertEquals(4000.00, newPayroll.getAllowances(), 0.001);
        assertEquals(3000.00, newPayroll.getDeductions(), 0.001);
        assertEquals(61000.00, newPayroll.getNetSalary(), 0.001);
        assertEquals(payDate, newPayroll.getPayDate());
    }

    @Test
    public void testToString() {
        payroll = new Payroll(103, 503, 70000.00, 6000.00, 2500.00, 73500.00, Date.valueOf("2025-04-08"));
        String expected = "Payroll [payrollId=103, employeeId=503, basicSalary=70000.0, allowances=6000.0, deductions=2500.0, netSalary=73500.0, payDate=2025-04-08]";
        assertEquals(expected, payroll.toString());
    }
}
