package sqlcodes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import database.DatabaseConnection;

public class Three {

    public static DefaultTableModel fetchPatientsWithSpouseEC() {

        String[] strColumnNames = {
            "Last Name",
            "First Name", 
            "Emergency Contact",
            "Relationship"
        };

        @SuppressWarnings("serial")
        DefaultTableModel tblModel = new DefaultTableModel(strColumnNames, 0) {
            @Override
            public boolean isCellEditable(int intRow, int intColumn) {
                return false; 
            }

            @Override
            public Class<?> getColumnClass(int intColumnIndex) {
                return String.class; 
            }
        };

        String strSQL = "SELECT p.p_lastname, p.p_firstname, p.EC_name AS emergency_contact, " +
                        "p.E2P_relation AS relationship " +
                        "FROM patient_info p " +
                        "WHERE p.E2P_relation = 'Spouse'";

        try (Connection objConn = DatabaseConnection.getConnection();
             Statement objStmt = objConn.createStatement();
             ResultSet objRS = objStmt.executeQuery(strSQL)) {

            while (objRS.next()) {
                Object[] objRow = {
                    objRS.getString("p_lastname"),
                    objRS.getString("p_firstname"),
                    objRS.getString("emergency_contact"),
                    objRS.getString("relationship")
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
