package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import frontend.UserPanel;

public class HipaaDAO {

    private UserPanel objUserInput;

    public HipaaDAO(UserPanel objUserInput) {
        this.objUserInput = objUserInput;
    }

    public void saveHipaaInfo() throws SQLException {
        String strSQL = "INSERT INTO hipaa_info " +
			            "(patient_ssn, HIPAA_name, HIPAA_PN, HIPAA2P_relation) " +
			            "VALUES (?, ?, ?, ?), (?, ?, ?, ?)";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL)) {

            // First HIPAA contact
            objStmt.setString(1, objUserInput.getTxtPatientSSN());
            objStmt.setString(2, objUserInput.getTxtHIPAA1Name());
            objStmt.setString(3, objUserInput.getTxtHIPAA1PhoneNumber());
            objStmt.setString(4, objUserInput.getTxtHIPAA1Relation());

            // Second HIPAA contact
            objStmt.setString(5, objUserInput.getTxtPatientSSN());
            objStmt.setString(6, objUserInput.getTxtHIPAA2Name());
            objStmt.setString(7, objUserInput.getTxtHIPAA2PhoneNumber());
            objStmt.setString(8, objUserInput.getTxtHIPAA2Relation());

            objStmt.executeUpdate();
        }
    }
}
