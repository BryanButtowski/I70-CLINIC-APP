package sqlcodes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import database.DatabaseConnection;



public class Eight {

    public static DefaultTableModel fetchInsuranceRegionStats() {

        String[] strColumnNames = {
            "Insurance Name",
            "Region", 
            "Patient Count",
            "Billhandler Count"
        };

        @SuppressWarnings("serial")
        DefaultTableModel tblModel = new DefaultTableModel(strColumnNames, 0) {
            @Override
            public boolean isCellEditable(int intRow, int intColumn) {
                return false; 
            }

            @Override
            public Class<?> getColumnClass(int intColumnIndex) {
                switch(intColumnIndex) {
                    case 0: 
                    case 1: 
                        return String.class;
                    case 2:
                    case 3:
                        return Integer.class;
                    default:
                        return Object.class;
                }
            }
        };

        String strSQL = "SELECT \n" +
                        "    INSURANCE_NAME.insurance_name,\n" +
                        "    patient_info.p_region,\n" +
                        "    COUNT(DISTINCT patient_info.patient_ssn) AS patient_count,\n" +
                        "    COUNT(DISTINCT billhandler_info.Billhandler_id) AS billhandler_count\n" +
                        "FROM patient_insurance\n" +
                        "JOIN insurance_name ON patient_insurance.insurance_code = insurance_name.insurance_code\n" +
                        "JOIN patient_info ON patient_insurance.patient_ssn = patient_info.patient_ssn\n" +
                        "JOIN billhandler_info ON patient_info.patient_ssn = billhandler_info.patient_ssn\n" +
                        "GROUP BY insurance_name.insurance_name, patient_info.p_region\n" +
                        "ORDER BY insurance_name, patient_count DESC";

        try (Connection objConn = DatabaseConnection.getConnection();
             Statement objStmt = objConn.createStatement();
             ResultSet objRS = objStmt.executeQuery(strSQL)) {

            while (objRS.next()) {
                Object[] objRow = {
                	objRS.getString("insurance_name"),
                	objRS.getString("p_region"),
                	objRS.getInt("patient_count"), 
                	objRS.getInt("billhandler_count")
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