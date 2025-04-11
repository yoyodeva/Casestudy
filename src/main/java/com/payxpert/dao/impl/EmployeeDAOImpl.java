package com.payxpert.dao.impl;

import java.sql.*;
import java.util.*;

import com.payxpert.dao.EmployeeDAO;
import com.payxpert.model.Employee;
import com.payxpert.util.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Employee (first_name, last_name, email, phone_number, hire_date, job_title, department, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getPhoneNumber());
            stmt.setDate(5, new java.sql.Date(employee.getHireDate().getTime()));
            stmt.setString(6, employee.getJobTitle());
            stmt.setString(7, employee.getDepartment());
            stmt.setDouble(8, employee.getSalary());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Employee employee = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Employee WHERE employee_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                employee = mapRowToEmployee(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Employee";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                employees.add(mapRowToEmployee(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Employee SET first_name = ?, last_name = ?, email = ?, phone_number = ?, job_title = ?, department = ?, salary = ? WHERE employee_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getPhoneNumber());
            stmt.setString(5, employee.getJobTitle());
            stmt.setString(6, employee.getDepartment());
            stmt.setDouble(7, employee.getSalary());
            stmt.setInt(8, employee.getEmployeeId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        String deleteFinancialSQL = "DELETE FROM FinancialRecord WHERE employee_id = ?";
        String deletePayrollSQL = "DELETE FROM Payroll WHERE employee_id = ?";
        String deleteTaxSQL = "DELETE FROM Tax WHERE employee_id = ?";
        String deleteEmployeeSQL = "DELETE FROM Employee WHERE employee_id = ?";
        
        Connection conn = null;

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); 

          
            try (PreparedStatement financialStmt = conn.prepareStatement(deleteFinancialSQL)) {
                financialStmt.setInt(1, employeeId);
                financialStmt.executeUpdate();
            }

            
            try (PreparedStatement payrollStmt = conn.prepareStatement(deletePayrollSQL)) {
                payrollStmt.setInt(1, employeeId);
                payrollStmt.executeUpdate();
            }

            
            try (PreparedStatement taxStmt = conn.prepareStatement(deleteTaxSQL)) {
                taxStmt.setInt(1, employeeId);
                taxStmt.executeUpdate();
            }

            
            try (PreparedStatement employeeStmt = conn.prepareStatement(deleteEmployeeSQL)) {
                employeeStmt.setInt(1, employeeId);
                int rowsAffected = employeeStmt.executeUpdate();
                if (rowsAffected == 0) {
                    System.out.println("");
                } else {
                    System.out.println("Employee and all related records deleted successfully.");
                }
            }

            conn.commit(); 
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.rollback(); 
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.setAutoCommit(true); 
                    conn.close();
                }
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }



    private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getInt("employee_id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setEmail(rs.getString("email"));
        employee.setPhoneNumber(rs.getString("phone_number"));
        employee.setHireDate(rs.getDate("hire_date"));
        employee.setJobTitle(rs.getString("job_title"));
        employee.setDepartment(rs.getString("department"));
        employee.setSalary(rs.getDouble("salary"));
        return employee;
    }
}
