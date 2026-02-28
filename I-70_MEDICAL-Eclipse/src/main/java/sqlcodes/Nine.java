package sqlcodes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import database.DatabaseConnection;


public class Nine {

    public static DefaultTableModel fetchPatientInsuranceStats() {
        String[] strColumnNames = {
            "Gender",
            "Region",
            "Patient Count",
            "Insurance Count",
            "Avg Insurance Per Patient"
        };

        @SuppressWarnings("serial")
        DefaultTableModel tblModel = new DefaultTableModel(strColumnNames, 0) {
            @Override
            public boolean isCellEditable(int intRow, int intColumn) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int intColumnIndex) {
                switch (intColumnIndex) {
                    case 0:
                    case 1:
                        return String.class;
                    case 2:
                    case 3:
                        return Integer.class;
                    case 4:
                        return Double.class;
                    default:
                        return Object.class;
                }
            }
        };

        String strSQL = "SELECT pi.p_gender, pi.p_region, " +
                        "COUNT(DISTINCT pi.patient_ssn) AS patient_count, " +
                        "COUNT(DISTINCT pi2s.insurance_code) AS insurance_count, " +
                        "CAST(COUNT(DISTINCT pi2s.insurance_code) AS FLOAT) / COUNT(DISTINCT pi.patient_ssn) AS avg_insurance_per_patient " +
                        "FROM patient_info pi " +
                        "LEFT JOIN patient_insurance pi2s ON pi.patient_ssn = pi2s.patient_ssn " +
                        "GROUP BY pi.p_gender, pi.p_region " +
                        "ORDER BY pi.p_region, pi.p_gender";

        try (Connection objConn = DatabaseConnection.getConnection();
             Statement objStmt = objConn.createStatement();
             ResultSet objRS = objStmt.executeQuery(strSQL)) {

            while (objRS.next()) {
                Object[] objRow = {
                    objRS.getString("p_gender"),
                    objRS.getString("p_region"),
                    objRS.getInt("patient_count"),
                    objRS.getInt("insurance_count"),
                    objRS.getDouble("avg_insurance_per_patient")
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
