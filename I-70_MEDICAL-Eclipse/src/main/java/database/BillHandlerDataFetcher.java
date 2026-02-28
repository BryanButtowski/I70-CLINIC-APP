package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class BillHandlerDataFetcher {

    public static DefaultTableModel fetchAllBillHandlerData() {
        String[] strColumnNames = {
            "BillHandler ID", "Name", "Birthdate", "Address",
            "Phone Number", "Occupation", "Employer",
            "Employer Address", "Employer Phone", "Patient SSN"
        };

        DefaultTableModel tblModel = new DefaultTableModel(strColumnNames, 0);

        String strSQL = "SELECT " +
			            "billhandler_id, BH_name, BH_birthdate, BH_address, " +
			            "BH_PN, BH_occupation, BH_employer, " +
			            "BH_employerAddress, BH_employerPN, patient_ssn " +
			            "FROM billhandler_info";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL);
             ResultSet objRS = objStmt.executeQuery()) {

            while (objRS.next()) {
                Object[] objRow = {
                    objRS.getString("billhandler_id"),
                    objRS.getString("BH_name"),
                    objRS.getDate("BH_birthdate"),
                    objRS.getString("BH_address"),
                    objRS.getString("BH_PN"),
                    objRS.getString("BH_occupation"),
                    objRS.getString("BH_employer"),
                    objRS.getString("BH_employerAddress"),
                    objRS.getString("BH_employerPN"),
                    objRS.getString("patient_ssn")
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
