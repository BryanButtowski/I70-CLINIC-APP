package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class PatientInsuranceDataFetcher {

    public static DefaultTableModel fetchAllPatientInsuranceData() {
        String[] columnNames = {
            "Patient SSN",
            "Subscriber SSN",
            "Insurance Code",
            "Subscriber-to-Patient Relationship"
        };

        @SuppressWarnings("serial")
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        String strSQL = "SELECT patient_ssn, subscriber_ssn, insurance_code, S2P_relation FROM patient_insurance";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL);
             ResultSet objRS = objStmt.executeQuery()) {

            while (objRS.next()) {
                Object[] row = {
                    objRS.getString("patient_ssn"),
                    objRS.getString("subscriber_ssn"),
                    objRS.getString("insurance_code"),
                    objRS.getString("S2P_relation")
                };
                tableModel.addRow(row);
            }
        } catch (SQLException objSqlEx) {
            objSqlEx.printStackTrace();
            return new DefaultTableModel(columnNames, 0);
        }

        return tableModel;
    }
}
