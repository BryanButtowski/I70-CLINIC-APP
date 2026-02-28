package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import frontend.UserPanel;

public class SubscriberDAO {
    private final UserPanel objUserInput;

    public SubscriberDAO(UserPanel objUserInput) {
        this.objUserInput = objUserInput;
    }

    public void saveSubscriberInfo() throws SQLException {
        String ssn1 = objUserInput.getTxtSubscriber1SSN();
        String ssn2 = objUserInput.getTxtSubscriber2SSN();

        try (Connection objConn = DatabaseConnection.getConnection()) {
            objConn.setAutoCommit(false);  

            // Handle first subscriber
            if (!ssnExists(objConn, ssn1)) {
                insertSubscriber(objConn, ssn1, 
                	objUserInput.getTxtSubscriber1Name(),
                	objUserInput.getDcSubscriber1Birthdate(),
                	objUserInput.getSubscriber1Gender(),
                	objUserInput.getTxtSubscriber1Employer());
            }

            // Handle second subscriber
            if (!ssnExists(objConn, ssn2)) {
                insertSubscriber(objConn, ssn2,
                	objUserInput.getTxtSubscriber2Name(),
                	objUserInput.getDcSubscriber2Birthdate(),
                	objUserInput.getSubscriber2Gender(),
                	objUserInput.getTxtSubscriber2Employer());
            }

            objConn.commit(); 
        }
    }

    private boolean ssnExists(Connection objConn, String ssn) throws SQLException {
        String strSQL = "SELECT 1 FROM subscriber_info WHERE subscriber_ssn = ?";
        try (PreparedStatement objStmt = objConn.prepareStatement(strSQL)) {
            objStmt.setString(1, ssn);
            return objStmt.executeQuery().next();
        }
    }

    private void insertSubscriber(Connection objConn, String ssn, String name, 
                                  String birthdateStr, String gender, String employer) 
                                  throws SQLException {
        String strSQL = "INSERT INTO subscriber_info " +
                        "(subscriber_ssn, subscriber_name, subscriber_birthdate, " +
                        "subscriber_gender, subscriber_employer) " +
                        "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement objStmt = objConn.prepareStatement(strSQL)) {
            objStmt.setString(1, ssn);
            objStmt.setString(2, name);
            objStmt.setDate(3, java.sql.Date.valueOf(birthdateStr));
            objStmt.setString(4, gender);
            objStmt.setString(5, employer);
            
            objStmt.executeUpdate();
        }
    }
}
