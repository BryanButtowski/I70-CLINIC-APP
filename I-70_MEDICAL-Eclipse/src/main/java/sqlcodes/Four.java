package sqlcodes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import database.DatabaseConnection;

public class Four {

    public static DefaultTableModel fetchTopOccupations() {

        String[] strColumnNames = {
            "Occupation",
            "Patient Count"
        };

        @SuppressWarnings("serial")
        DefaultTableModel tblModel = new DefaultTableModel(strColumnNames, 0) {
            @Override
            public boolean isCellEditable(int intRow, int intColumn) {
                return false; 
            }

            @Override
            public Class<?> getColumnClass(int intColumnIndex) {
                return intColumnIndex == 1 ? Integer.class : String.class;
            }
        };

        String strSQL = "SELECT p_occupation, COUNT(*) AS count " +
                        "FROM patient_info " +
                        "GROUP BY p_occupation " +
                        "ORDER BY count DESC ";

        try (Connection objConn = DatabaseConnection.getConnection();
             Statement objStmt = objConn.createStatement();
             ResultSet objRS = objStmt.executeQuery(strSQL)) {

            while (objRS.next()) {
                Object[] objRow = {
                    objRS.getString("p_occupation"),
                    objRS.getInt("count")
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
