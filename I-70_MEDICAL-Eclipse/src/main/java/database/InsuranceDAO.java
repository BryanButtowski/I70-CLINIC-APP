package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import frontend.UserPanel;

public class InsuranceDAO {
    private UserPanel objUserInput;

    public InsuranceDAO(UserPanel objUserInput) {
        this.objUserInput = objUserInput;
    }

    private String getInsuranceCode(String strInsuranceName) throws SQLException {
        String strSQL = "SELECT insurance_code FROM insurance_name WHERE LOWER(insurance_name) = LOWER(?)";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL)) {

            objStmt.setString(1, strInsuranceName);
            try (ResultSet objRS = objStmt.executeQuery()) {
                if (objRS.next()) {
                    return objRS.getString("insurance_code");
                } else {
                    throw new SQLException("Insurance not found: " + strInsuranceName);
                }
            }
        }
    }

    public void saveInsuranceInfo() throws SQLException {
        insertInsuranceNames();

        String strCode1 = getInsuranceCode(objUserInput.getTxtInsurance1Name());
        String strCode2 = getInsuranceCode(objUserInput.getTxtInsurance2Name());

        savePatientInsurance(strCode1, strCode2);
    }

    private void savePatientInsurance(String strCode1, String strCode2) throws SQLException {
        String strSQL = "INSERT INTO patient_insurance " +
		                "(patient_ssn, insurance_code, subscriber_ssn, S2P_relation) " +
		                "VALUES (?, ?, ?, ?), (?, ?, ?, ?)";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL)) {

            objConn.setAutoCommit(false);

            try {
                objStmt.setString(1, objUserInput.getTxtPatientSSN());
                objStmt.setString(2, strCode1);
                objStmt.setString(3, objUserInput.getTxtSubscriber1SSN());
                objStmt.setString(4, objUserInput.getTxtSubscriber1Relation());

                objStmt.setString(5, objUserInput.getTxtPatientSSN());
                objStmt.setString(6, strCode2);
                objStmt.setString(7, objUserInput.getTxtSubscriber2SSN());
                objStmt.setString(8, objUserInput.getTxtSubscriber2Relation());

                int intRowsInserted = objStmt.executeUpdate();
                if (intRowsInserted != 2) {
                    throw new SQLException("Failed to insert both insurance records");
                }

                objConn.commit();
            } catch (SQLException objSqlEx) {
                objConn.rollback();
                throw objSqlEx;
            } finally {
                objConn.setAutoCommit(true);
            }
        }
    }

    private void insertInsuranceNames() throws SQLException {
        String strSQL = "INSERT INTO insurance_name (insurance_name) " +
		                "SELECT ? FROM DUAL WHERE NOT EXISTS ( " +
		                "SELECT 1 FROM insurance_name WHERE LOWER(insurance_name) = LOWER(?) )";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL)) {

            objStmt.setString(1, objUserInput.getTxtInsurance1Name());
            objStmt.setString(2, objUserInput.getTxtInsurance1Name());
            objStmt.executeUpdate();

            objStmt.setString(1, objUserInput.getTxtInsurance2Name());
            objStmt.setString(2, objUserInput.getTxtInsurance2Name());
            objStmt.executeUpdate();
        }
    }

    public void updateInsuranceInfo() throws SQLException {
        try (Connection objConn = DatabaseConnection.getConnection()) {
            objConn.setAutoCommit(false);

            try (PreparedStatement objStmt = objConn.prepareStatement(
                    "DELETE FROM patient_insurance WHERE patient_ssn = ?")) {
                objStmt.setString(1, objUserInput.getTxtPatientSSN());
                objStmt.executeUpdate();
            }

            processInsuranceWithDuplicateProtection(objConn, objUserInput.getTxtInsurance1Name(),
                    objUserInput.getTxtSubscriber1SSN(), objUserInput.getTxtSubscriber1Relation());

            processInsuranceWithDuplicateProtection(objConn, objUserInput.getTxtInsurance2Name(),
                    objUserInput.getTxtSubscriber2SSN(), objUserInput.getTxtSubscriber2Relation());

            objConn.commit();
        }
    }

    private void processInsuranceWithDuplicateProtection(Connection objConn, String strName,
                                                         String strSSN, String strRelation) throws SQLException {
        if (strName == null || strName.trim().isEmpty()) return;

        String strCode = getOrCreateInsuranceCode(objConn, strName);

        try (PreparedStatement objStmt = objConn.prepareStatement(
                "INSERT INTO patient_insurance " +
                "(patient_ssn, insurance_code, subscriber_ssn, S2P_relation) " +
                "SELECT ?, ?, ?, ? " +
                "WHERE NOT EXISTS ( " +
                "   SELECT 1 FROM patient_insurance " +
                "   WHERE patient_ssn = ? AND insurance_code = ? )")) {

            objStmt.setString(1, objUserInput.getTxtPatientSSN());
            objStmt.setString(2, strCode);
            objStmt.setString(3, strSSN);
            objStmt.setString(4, strRelation);
            objStmt.setString(5, objUserInput.getTxtPatientSSN());
            objStmt.setString(6, strCode);

            int intRowsAffected = objStmt.executeUpdate();
            if (intRowsAffected == 0) {
                System.out.println("Insurance " + strName + " already exists for patient - not added again");
            }
        }
    }

    private String getOrCreateInsuranceCode(Connection objConn, String strName) throws SQLException {
        try (PreparedStatement objStmt = objConn.prepareStatement(
                "SELECT insurance_code FROM insurance_name WHERE insurance_name = ?")) {
            objStmt.setString(1, strName);
            ResultSet objRS = objStmt.executeQuery();
            if (objRS.next()) {
                return objRS.getString(1);
            }
        }

        try (PreparedStatement objStmt = objConn.prepareStatement(
                "INSERT INTO insurance_name (insurance_name) VALUES (?)",
                Statement.RETURN_GENERATED_KEYS)) {
            objStmt.setString(1, strName);
            objStmt.executeUpdate();

            try (ResultSet objRS = objStmt.getGeneratedKeys()) {
                if (objRS.next()) {
                    return objRS.getString(1);
                }
            }
        }

        throw new SQLException("Failed to get or create insurance code for: " + strName);
    }
}
