package sqlcodes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import database.DatabaseConnection;

public class Ten {

    @SuppressWarnings("serial")
    public static DefaultTableModel fetchAbcCorpPatients() {
        String[] strColumnNames = {
            "Last Name",
            "First Name", 
            "Billhandler Name",
            "Billhandler Employer"
        };

        DefaultTableModel tblModel = new DefaultTableModel(strColumnNames, 0) {
            @Override
            public boolean isCellEditable(int intRow, int intColumn) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int intColumnIndex) {
                return String.class; // All columns contain text
            }
        };

        String strSQL = "SELECT p.p_lastname, p.p_firstname, " +
                        "b.BH_name, b.BH_employer " +
                        "FROM PATIENT_INFO p " +
                        "JOIN BILLHANDLER_INFO b ON p.patient_ssn = b.patient_ssn " +
                        "WHERE b.BH_employer = 'St. Jude Hospital'";

        try (Connection objConn = DatabaseConnection.getConnection();
             Statement objStmt = objConn.createStatement();
             ResultSet objRS = objStmt.executeQuery(strSQL)) {

            while (objRS.next()) {
                Object[] objRow = {
                    objRS.getString("p_lastname"),
                    objRS.getString("p_firstname"),
                    objRS.getString("BH_name"),
                    objRS.getString("BH_employer")
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
