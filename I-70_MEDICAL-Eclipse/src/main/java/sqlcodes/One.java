package sqlcodes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import database.DatabaseConnection;

public class One {

    public static DefaultTableModel fetchPatientContactData() {

        String[] strColumnNames = {
            "First Name", 
            "Last Name", 
            "Home Phone", 
            "Cell Phone"
        };

        @SuppressWarnings("serial")
        DefaultTableModel tblModel = new DefaultTableModel(strColumnNames, 0) {
            @Override
            public boolean isCellEditable(int intRow, int intColumn) {
                return false;
            }
        };

        String strSQL = "SELECT p_firstname, p_lastname, p_homePN, p_cellPN FROM patient_info";

        try (Connection objConn = DatabaseConnection.getConnection();
             Statement objStmt = objConn.createStatement();
             ResultSet objRS = objStmt.executeQuery(strSQL)) {

            while (objRS.next()) {
                Object[] objRow = {
                    objRS.getString("p_firstname"),
                    objRS.getString("p_lastname"),
                    objRS.getString("p_homePN"),
                    objRS.getString("p_cellPN")
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
