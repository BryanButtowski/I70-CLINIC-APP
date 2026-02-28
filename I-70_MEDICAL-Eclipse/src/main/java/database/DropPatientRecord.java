package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DropPatientRecord {

    public static boolean deletePatientRecord(String strPatientSSN) throws SQLException {
        try (Connection objConn = DatabaseConnection.getConnection()) {
            objConn.setAutoCommit(false); // Start transaction

            try {
                // 1. First delete all dependent records
                deleteFromTable(objConn, "billhandler_info", "patient_ssn", strPatientSSN);
                deleteFromTable(objConn, "patient_insurance", "patient_ssn", strPatientSSN);
                // Add any other tables with foreign keys to patient_info here

                // 2. Then delete the patient
                int intPatientRows = deleteFromTable(objConn, "patient_info", "patient_ssn", strPatientSSN);

                if (intPatientRows == 0) {
                    objConn.rollback();
                    return false; // Patient didn't exist
                }

                objConn.commit();
                return true;
            } catch (SQLException objSqlEx) {
                objConn.rollback();
                throw objSqlEx;
            }
        }
    }

    private static int deleteFromTable(Connection objConn, String strTable, String strColumn, String strValue)
            throws SQLException {
        try (PreparedStatement objStmt = objConn.prepareStatement(
                "DELETE FROM " + strTable + " WHERE " + strColumn + " = ?")) {
            objStmt.setString(1, strValue);
            return objStmt.executeUpdate();
        }
    }
}
