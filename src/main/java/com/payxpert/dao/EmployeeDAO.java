package com.payxpert.dao;

import java.util.List;
import com.payxpert.model.Employee;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
}
