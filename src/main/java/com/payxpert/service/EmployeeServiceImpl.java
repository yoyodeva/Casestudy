package com.payxpert.service;

import com.payxpert.dao.impl.EmployeeDAOImpl;
import com.payxpert.model.Employee;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAOImpl employeeDAO;

    public EmployeeServiceImpl() {
        this.employeeDAO = new EmployeeDAOImpl();
    }
	
    public boolean addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
		return false;
    }

  
    public Employee getEmployeeById(int employeeId) {
        return employeeDAO.getEmployeeById(employeeId);
    }

    
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

  
    public boolean updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
		return false;
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        employeeDAO.deleteEmployee(employeeId);
		return false;
    }

	public double calculateNetSalary(double basicSalary, double allowances, double deductions) {
	
		return 0;
	}
}
