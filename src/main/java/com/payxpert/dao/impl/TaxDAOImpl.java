package com.payxpert.dao.impl;

import java.sql.*;
import java.util.*;
import com.payxpert.dao.TaxDAO;
import com.payxpert.model.Tax;
import com.payxpert.util.DBConnection;

public class TaxDAOImpl implements TaxDAO {

    @Override
    public void addTax(Tax tax) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Tax (tax_id, employee_id, tax_year, tax_amount) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, tax.getTaxId());
            stmt.setInt(2, tax.getEmployeeId());
            stmt.setInt(3, tax.getTaxYear());
            stmt.setDouble(4, tax.getTaxAmount());
            
            stmt.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


   
    @Override
    public Tax getTaxById(int taxId) {
        Tax tax = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Tax WHERE tax_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, taxId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tax = new Tax();
                tax.setTaxId(rs.getInt("tax_id"));
                tax.setEmployeeId(rs.getInt("employee_id"));
                tax.setTaxYear(rs.getInt("tax_year"));
                tax.setTaxAmount(rs.getDouble("tax_amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tax;
    }


    @Override
    public List<Tax> getTaxesByEmployeeId(int employeeId) {
        List<Tax> taxes = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Tax WHERE employee_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tax tax = new Tax();
                tax.setTaxId(rs.getInt("tax_id"));
                tax.setEmployeeId(rs.getInt("employee_id"));
                tax.setTaxYear(rs.getInt("tax_year"));
                tax.setTaxAmount(rs.getDouble("tax_amount"));
                taxes.add(tax);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taxes;
    }


    @Override
    public void updateTax(Tax tax) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Tax SET tax_amount = ? WHERE tax_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, tax.getTaxAmount());
            stmt.setInt(2, tax.getTaxId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTax(int taxId) {
        String deleteTaxSQL = "DELETE FROM Tax WHERE tax_id = ?";
        Connection conn = null;

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(deleteTaxSQL)) {
                stmt.setInt(1, taxId);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected == 0) {
                    System.out.println("Tax record not found or could not be deleted.");
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
