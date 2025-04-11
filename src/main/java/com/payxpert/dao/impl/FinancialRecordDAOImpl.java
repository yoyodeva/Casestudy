package com.payxpert.dao.impl;

import java.sql.*;
import java.util.*;
import com.payxpert.dao.FinancialRecordDAO;
import com.payxpert.model.FinancialRecord;
import com.payxpert.util.DBConnection;

public class FinancialRecordDAOImpl implements FinancialRecordDAO {

    @Override
    public void addFinancialRecord(FinancialRecord record) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO FinancialRecord (employee_id, record_date, description, amount, record_type) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, record.getEmployeeId());
            stmt.setDate(2, record.getRecordDate());
            stmt.setString(3, record.getDescription());
            stmt.setDouble(4, record.getAmount());
            stmt.setString(5, record.getRecordType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FinancialRecord getFinancialRecordById(int recordId) {
        FinancialRecord record = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM FinancialRecord WHERE record_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, recordId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                record = new FinancialRecord();
                record.setRecordId(rs.getInt("record_id"));
                record.setEmployeeId(rs.getInt("employee_id"));
                record.setRecordDate(rs.getDate("record_date"));
                record.setDescription(rs.getString("description"));
                record.setAmount(rs.getDouble("amount"));
                record.setRecordType(rs.getString("record_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record;
    }

    @Override
    public List<FinancialRecord> getFinancialRecordsByEmployeeId(int employeeId) {
        List<FinancialRecord> records = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM FinancialRecord WHERE employee_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FinancialRecord record = new FinancialRecord();
                record.setRecordId(rs.getInt("record_id"));
                record.setEmployeeId(rs.getInt("employee_id"));
                record.setRecordDate(rs.getDate("record_date"));
                record.setDescription(rs.getString("description"));
                record.setAmount(rs.getDouble("amount"));
                record.setRecordType(rs.getString("record_type"));
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    @Override
    public void updateFinancialRecord(FinancialRecord record) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE FinancialRecord SET description = ?, amount = ?, record_type = ? WHERE record_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, record.getDescription());
            stmt.setDouble(2, record.getAmount());
            stmt.setString(3, record.getRecordType());
            stmt.setInt(4, record.getRecordId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFinancialRecord(int recordId) {
        String deleteRecordSQL = "DELETE FROM FinancialRecord WHERE record_id = ?";
        Connection conn = null;

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(deleteRecordSQL)) {
                stmt.setInt(1, recordId);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected == 0) {
                    System.out.println("Financial record not found or could not be deleted.");
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
