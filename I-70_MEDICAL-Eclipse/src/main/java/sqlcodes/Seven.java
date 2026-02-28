package sqlcodes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import database.DatabaseConnection;

public class Seven {

    public static DefaultTableModel fetchInsuranceAvgAge() {
        String[] strColumnNames = {
            "Insurance Provider",
            "Average Age"
        };

        @SuppressWarnings("serial")
        DefaultTableModel tblModel = new DefaultTableModel(strColumnNames, 0) {
            @Override
            public boolean isCellEditable(int intRow, int intColumn) {
                return false; 
            }

            @Override
            public Class<?> getColumnClass(int intColumnIndex) {
                return intColumnIndex == 1 ? Double.class : String.class;
            }
        };

        String strSQL = "SELECT i.insurance_name, AVG(p.p_age) AS avg_age " +
                        "FROM insurance_name i " +
                        "JOIN patient_insurance pi ON i.insurance_code = pi.insurance_code " +
                        "JOIN patient_info p ON pi.patient_ssn = p.patient_ssn " +
                        "GROUP BY i.insurance_name " +
                        "ORDER BY avg_age DESC";

        try (Connection objConn = DatabaseConnection.getConnection();
             Statement objStmt = objConn.createStatement();
             ResultSet objRS = objStmt.executeQuery(strSQL)) {

            while (objRS.next()) {
                Object[] objRow = {
                    objRS.getString("insurance_name"),
                    objRS.getDouble("avg_age")
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
