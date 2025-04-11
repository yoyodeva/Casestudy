package com.payxpert.test;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import com.payxpert.model.Employee;

public class EmployeeTest {

    private Employee employee;
    private Date hireDate;

    @Before
    public void setUp() {
        hireDate = new Date();
        employee = new Employee(1, "John", "Doe", "john.doe@example.com", "1234567890", hireDate, "Developer", "IT", 75000.00);
    }

    @Test
    public void testGetters() {
        assertEquals(1, employee.getEmployeeId());
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("john.doe@example.com", employee.getEmail());
        assertEquals("1234567890", employee.getPhoneNumber());
        assertEquals(hireDate, employee.getHireDate());
        assertEquals("Developer", employee.getJobTitle());
        assertEquals("IT", employee.getDepartment());
        assertEquals(75000.00, employee.getSalary(), 0.001);
    }

    @Test
    public void testSetters() {
        Date newHireDate = new Date();
        employee.setEmployeeId(2);
        employee.setFirstName("Jane");
        employee.setLastName("Smith");
        employee.setEmail("jane.smith@example.com");
        employee.setPhoneNumber("0987654321");
        employee.setHireDate(newHireDate);
        employee.setJobTitle("Manager");
        employee.setDepartment("HR");
        employee.setSalary(85000.00);

        assertEquals(2, employee.getEmployeeId());
        assertEquals("Jane", employee.getFirstName());
        assertEquals("Smith", employee.getLastName());
        assertEquals("jane.smith@example.com", employee.getEmail());
        assertEquals("0987654321", employee.getPhoneNumber());
        assertEquals(newHireDate, employee.getHireDate());
        assertEquals("Manager", employee.getJobTitle());
        assertEquals("HR", employee.getDepartment());
        assertEquals(85000.00, employee.getSalary(), 0.001);
    }

    @Test
    public void testToString() {
        String toStringOutput = employee.toString();
        assertTrue(toStringOutput.contains("Employee"));
        assertTrue(toStringOutput.contains("John"));
        assertTrue(toStringOutput.contains("Doe"));
        assertTrue(toStringOutput.contains("john.doe@example.com"));
    }
}
