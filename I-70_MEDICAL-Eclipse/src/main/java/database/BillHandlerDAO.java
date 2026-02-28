package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import frontend.UserPanel;

public class BillHandlerDAO {

    private UserPanel objUserInput;

    public BillHandlerDAO(UserPanel objUserInput) {
        this.objUserInput = objUserInput;
    }

    public void saveBillHandlerInfo() throws SQLException {
        String strSQL = "INSERT INTO billhandler_info " +
			            "(BH_name, BH_birthdate, BH_address, BH_PN, BH_occupation, " +
			            "BH_employer, BH_employerAddress, BH_employerPN, patient_ssn) " +
			            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS)) {

            objStmt.setString(1, objUserInput.getTxtResponsibleName());
            objStmt.setDate(2, java.sql.Date.valueOf(objUserInput.getDcResponsibleBirthdate()));  
            objStmt.setString(3, objUserInput.getTxtResponsibleAddress());
            objStmt.setString(4, objUserInput.getTxtResponsiblePhoneNumber());
            objStmt.setString(5, objUserInput.getTxtResponsibleOccupation());
            objStmt.setString(6, objUserInput.getTxtResponsibleEmployer());
            objStmt.setString(7, objUserInput.getTxtResponsibleEmployerAddress());
            objStmt.setString(8, objUserInput.getTxtResponsibleEmployerPhoneNumber());  
            objStmt.setString(9, objUserInput.getTxtPatientSSN());

            objStmt.executeUpdate();
        }
    }

    public void updateBillHandlerInfo(String strPatientSSN) throws SQLException {
        String strSQL = "UPDATE billhandler_info SET " +
			            "BH_name = ?, " +
			            "BH_birthdate = ?, " +
			            "BH_address = ?, " +
			            "BH_PN = ?, " +
			            "BH_occupation = ?, " +
			            "BH_employer = ?, " +
			            "BH_employerAddress = ?, " +
			            "BH_employerPN = ? " +
			            "WHERE patient_ssn = ?";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL)) {

            objStmt.setString(1, objUserInput.getTxtResponsibleName());
            objStmt.setDate(2, java.sql.Date.valueOf(objUserInput.getDcResponsibleBirthdate()));
            objStmt.setString(3, objUserInput.getTxtResponsibleAddress());
            objStmt.setString(4, objUserInput.getTxtResponsiblePhoneNumber());
            objStmt.setString(5, objUserInput.getTxtResponsibleOccupation());
            objStmt.setString(6, objUserInput.getTxtResponsibleEmployer());
            objStmt.setString(7, objUserInput.getTxtResponsibleEmployerAddress());
            objStmt.setString(8, objUserInput.getTxtResponsibleEmployerPhoneNumber());
            objStmt.setString(9, strPatientSSN);

            int intRowsAffected = objStmt.executeUpdate();

            if (intRowsAffected == 0) {
                throw new SQLException("Update failed - No bill handler found for patient SSN: " + strPatientSSN);
            }
        }
    }
}
