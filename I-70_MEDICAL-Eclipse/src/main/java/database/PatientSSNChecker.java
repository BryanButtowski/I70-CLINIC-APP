package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientSSNChecker {

    public static boolean isPatientSSNExists(String ssnToCheck) throws SQLException {
        if (ssnToCheck == null || ssnToCheck.trim().isEmpty()) {
            return false;
        }

        String strSQL = "SELECT 1 FROM patient_info WHERE patient_ssn = ?";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL)) {

            objStmt.setString(1, ssnToCheck.trim());

            try (ResultSet objRS = objStmt.executeQuery()) {
                return objRS.next(); // Returns true if a record was found
            }
        }
    }
}
