package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminCredentialChecker {

    public static boolean isAdminPasswordExists(String strCredentialToCheck) throws SQLException {
        if (strCredentialToCheck == null || strCredentialToCheck.trim().isEmpty()) {
            return false;
        }

        String strSQL = "SELECT 1 FROM admin_credentials WHERE BINARY password = ?";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL)) {

            objStmt.setString(1, strCredentialToCheck.trim());

            try (ResultSet objRS = objStmt.executeQuery()) {
                return objRS.next(); 
            }
        }
    }
}
