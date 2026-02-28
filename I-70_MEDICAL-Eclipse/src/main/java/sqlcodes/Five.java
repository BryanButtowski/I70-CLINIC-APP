package sqlcodes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import database.DatabaseConnection;

public class Five {

    public static DefaultTableModel fetchInsuranceGenderStats() {
        // Column names for the table
        String[] strColumnNames = {
            "Insurance Name",
            "Gender",
            "Patient Count"
        };

        @SuppressWarnings("serial")
        DefaultTableModel tblModel = new DefaultTableModel(strColumnNames, 0) {
            @Override
            public boolean isCellEditable(int intRow, int intColumn) {
                return false; // Make table read-only
            }

            @Override
            public Class<?> getColumnClass(int intColumnIndex) {
                if (intColumnIndex == 2) {
                    return Integer.class;
                }
                return String.class;
            }
        };

        String strSQL = "SELECT i.insurance_name, p.p_gender, COUNT(*) AS patient_count " +
                        "FROM patient_info p " +
                        "JOIN patient_insurance pi ON p.patient_ssn = pi.patient_ssn " +
                        "JOIN insurance_name i ON pi.insurance_code = i.insurance_code " +
                        "GROUP BY i.insurance_name, p.p_gender " +
                        "ORDER BY i.insurance_name, patient_count DESC";

        try (Connection objConn = DatabaseConnection.getConnection();
             Statement objStmt = objConn.createStatement();
             ResultSet objRS = objStmt.executeQuery(strSQL)) {

            while (objRS.next()) {
                Object[] objRow = {
                    objRS.getString("insurance_name"),
                    objRS.getString("p_gender"),
                    objRS.getInt("patient_count")
                };
                tblModel.addRow(objRow);
            }
        } catch (SQLException objSqlEx) {
            objSqlEx.printStackTrace();
            return new DefaultTableModel(strColumnNames, 0);
        }

        return tblModel;
    }
}
