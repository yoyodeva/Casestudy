package com.payxpert.service;

import com.payxpert.model.Employee;
import java.util.List;

public interface EmployeeService {
    boolean addEmployee(Employee employee);
    Employee getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(int employeeId);
}
