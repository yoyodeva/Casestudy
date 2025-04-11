package com.payxpert.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.payxpert.model.Tax;

public class TaxTest {

    private Tax tax;

    @Before
    public void setUp() {
        tax = new Tax();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(tax);
    }

    @Test
    public void testParameterizedConstructor() {
        Tax taxParam = new Tax(1, 101, 2500.0, 2025);
        assertEquals(1, taxParam.getTaxId());
        assertEquals(101, taxParam.getEmployeeId());
        assertEquals(2500.0, taxParam.getTaxAmount(), 0.001);
        assertEquals(2025, taxParam.getTaxYear());
    }

    @Test
    public void testSetAndGetTaxId() {
        tax.setTaxId(2);
        assertEquals(2, tax.getTaxId());
    }

    @Test
    public void testSetAndGetEmployeeId() {
        tax.setEmployeeId(202);
        assertEquals(202, tax.getEmployeeId());
    }

    @Test
    public void testSetAndGetTaxAmount() {
        tax.setTaxAmount(3500.75);
        assertEquals(3500.75, tax.getTaxAmount(), 0.001);
    }

    @Test
    public void testSetAndGetTaxYear() {
        tax.setTaxYear(2024);
        assertEquals(2024, tax.getTaxYear());
    }

    @Test
    public void testToString() {
        tax = new Tax(3, 303, 4500.0, 2023);
        String expected = "Tax [taxId=3, employeeId=303, taxAmount=4500.0, taxYear=2023]";
        assertEquals(expected, tax.toString());
    }
}
