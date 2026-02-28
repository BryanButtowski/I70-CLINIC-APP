package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class HipaaDataFetcher {

    public static DefaultTableModel fetchAllHipaaData() {
        String[] strColumnNames = {
            "Patient SSN", 
            "HIPAA Contact Name", 
            "HIPAA Contact Phone", 
            "Relationship to Patient"
        };

        DefaultTableModel tblModel = new DefaultTableModel(strColumnNames, 0);

        String strSQL = "SELECT " +
			            "patient_ssn, HIPAA_name, HIPAA_PN, HIPAA2P_relation " +
			            "FROM hipaa_info";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL);
             ResultSet objRS = objStmt.executeQuery()) {

            while (objRS.next()) {
                Object[] objRow = {
                    objRS.getString("patient_ssn"),
                    objRS.getString("HIPAA_name"),
                    objRS.getString("HIPAA_PN"),
                    objRS.getString("HIPAA2P_relation")
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
