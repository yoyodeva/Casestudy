package com.payxpert.dao.impl;

import java.sql.*;
import java.util.*;
import com.payxpert.dao.PayrollDAO;
import com.payxpert.model.Payroll;
import com.payxpert.util.DBConnection;

public class PayrollDAOImpl implements PayrollDAO {

    @Override
    public void addPayroll(Payroll payroll) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Payroll (payroll_id, employee_id, pay_date, basic_salary, bonus, deductions, net_salary) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, payroll.getPayrollId());
            stmt.setInt(2, payroll.getEmployeeId());
            stmt.setDate(3, payroll.getPayDate());
            stmt.setDouble(4, payroll.getBasicSalary());
            stmt.setDouble(5, payroll.getAllowances());
            stmt.setDouble(6, payroll.getDeductions());
            stmt.setDouble(7, payroll.getNetSalary());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Payroll getPayrollById(int payrollId) {
        Payroll payroll = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Payroll WHERE payroll_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, payrollId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                payroll = new Payroll(
                    rs.getInt("payroll_id"),
                    rs.getInt("employee_id"),
                    rs.getDouble("basic_salary"),
                    rs.getDouble("bonus"),
                    rs.getDouble("deductions"),
                    rs.getDouble("net_salary"),
                    rs.getDate("pay_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payroll;
    }

    @Override
    public List<Payroll> getPayrollsByEmployeeId(int employeeId) {
        List<Payroll> payrolls = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Payroll WHERE employee_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Payroll payroll = new Payroll(
                    rs.getInt("payroll_id"),
                    rs.getInt("employee_id"),
                    rs.getDouble("basic_salary"),
                    rs.getDouble("bonus"),
                    rs.getDouble("deductions"),
                    rs.getDouble("net_salary"),
                    rs.getDate("pay_date")
                );
                payrolls.add(payroll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payrolls;
    }

    @Override
    public void updatePayroll(Payroll payroll) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Payroll SET basic_salary = ?, bonus = ?, deductions = ?, net_salary = ?, pay_date = ? WHERE payroll_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, payroll.getBasicSalary());
            stmt.setDouble(2, payroll.getAllowances());
            stmt.setDouble(3, payroll.getDeductions());
            stmt.setDouble(4, payroll.getNetSalary());
            stmt.setDate(5, payroll.getPayDate());
            stmt.setInt(6, payroll.getPayrollId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePayroll(int payrollId) {
        String deletePayrollSQL = "DELETE FROM Payroll WHERE payroll_id = ?";
        Connection conn = null;

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); 

            try (PreparedStatement stmt = conn.prepareStatement(deletePayrollSQL)) {
                stmt.setInt(1, payrollId);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected == 0) {
                    System.out.println("Payroll not found or could not be deleted.");
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

}
