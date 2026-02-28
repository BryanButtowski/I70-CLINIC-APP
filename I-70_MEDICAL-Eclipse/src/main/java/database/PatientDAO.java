package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import backend.HelperMethods;
import frontend.UserPanel;

public class PatientDAO {

    private UserPanel objUserInput;

    public PatientDAO(UserPanel objUserInput) {
        this.objUserInput = objUserInput;
    }

    public void savePatientInfo() throws SQLException {
        String strSQL = "INSERT INTO patient_info " +
			            "(patient_ssn, registration_date, prev_physician, p_lastname, p_firstname, p_middlename, " +
			            "p_honorifics, p_birthdate, p_age, p_gender, p_maritalstatus, " +
			            "p_homePN, p_workPN, p_cellPN, p_street_brgy, p_city, p_region, " +
			            "p_zipcode, p_POBox, p_province, p_ethnicity, p_race, p_occupation, " +
			            "p_employer, p_employerPN, EC_name, E2P_relation, EC_PN, patient_guardian_authorization) " +
			            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL)) {

            objStmt.setString(1, objUserInput.getTxtPatientSSN());
            objStmt.setDate(2, Date.valueOf(HelperMethods.getCurrentDate()));
            objStmt.setString(3, objUserInput.getTxtPreviousPhysician());
            objStmt.setString(4, objUserInput.getTxtPatientLastName());
            objStmt.setString(5, objUserInput.getTxtPatientFirstName());
            objStmt.setString(6, objUserInput.getTxtPatientMiddleName());
            objStmt.setString(7, objUserInput.getTxtPatientHonorifics());
            objStmt.setDate(8, Date.valueOf(objUserInput.getTxtPatientBirthdate()));
            objStmt.setInt(9, Integer.parseInt(objUserInput.getTxtPatientAge()));
            objStmt.setString(10, objUserInput.getTxtPatientGender());
            objStmt.setString(11, objUserInput.getPatientMaritalStatus());
            objStmt.setString(12, objUserInput.getTxtPatientHPN());
            objStmt.setString(13, objUserInput.getTxtPatientWPN());
            objStmt.setString(14, objUserInput.getTxtPatientCPN());
            objStmt.setString(15, objUserInput.getTxtPatientStreet());
            objStmt.setString(16, objUserInput.getTxtPatientCity());
            objStmt.setString(17, objUserInput.getTxtPatientRegion());
            objStmt.setString(18, objUserInput.getTxtPatientZipCode());
            objStmt.setString(19, objUserInput.getTxtPatientPO());
            objStmt.setString(20, objUserInput.getTxtPatientProvince());
            objStmt.setString(21, objUserInput.getTxtPatientEthnicity());
            objStmt.setString(22, objUserInput.getTxtPatientRace());
            objStmt.setString(23, objUserInput.getTxtPatientOccupation());
            objStmt.setString(24, objUserInput.getTxtPatientEmployer());
            objStmt.setString(25, objUserInput.getTxtPatientEmployerPN());
            objStmt.setString(26, objUserInput.getTxtPatientECName());
            objStmt.setString(27, objUserInput.getTxtPatientToEC());
            objStmt.setString(28, objUserInput.getTxtPatientECPhoneNumber());
            objStmt.setString(29, "Yes");

            objStmt.executeUpdate();
        }
    }

    public void updatePatientInfo(String strPatientSSN) throws SQLException {
        String strSQL = "UPDATE patient_info SET " +
		                "registration_date = ?, " +
		                "prev_physician = ?, " +
		                "p_lastname = ?, " +
		                "p_firstname = ?, " +
		                "p_middlename = ?, " +
		                "p_honorifics = ?, " +
		                "p_birthdate = ?, " +
		                "p_age = ?, " +
		                "p_gender = ?, " +
		                "p_maritalstatus = ?, " +
		                "p_homePN = ?, " +
		                "p_workPN = ?, " +
		                "p_cellPN = ?, " +
		                "p_street_brgy = ?, " +
		                "p_city = ?, " +
		                "p_region = ?, " +
		                "p_zipcode = ?, " +
		                "p_POBox = ?, " +
		                "p_province = ?, " +
		                "p_ethnicity = ?, " +
		                "p_race = ?, " +
		                "p_occupation = ?, " +
		                "p_employer = ?, " +
		                "p_employerPN = ?, " +
		                "EC_name = ?, " +
		                "E2P_relation = ?, " +
		                "EC_PN = ?, " +
		                "patient_guardian_authorization = ? " +
		                "WHERE patient_ssn = ?";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL)) {

            objStmt.setDate(1, Date.valueOf(HelperMethods.getCurrentDate()));
            objStmt.setString(2, objUserInput.getTxtPreviousPhysician());
            objStmt.setString(3, objUserInput.getTxtPatientLastName());
            objStmt.setString(4, objUserInput.getTxtPatientFirstName());
            objStmt.setString(5, objUserInput.getTxtPatientMiddleName());
            objStmt.setString(6, objUserInput.getTxtPatientHonorifics());
            objStmt.setDate(7, Date.valueOf(objUserInput.getTxtPatientBirthdate()));
            objStmt.setInt(8, Integer.parseInt(objUserInput.getTxtPatientAge()));
            objStmt.setString(9, objUserInput.getTxtPatientGender());
            objStmt.setString(10, objUserInput.getPatientMaritalStatus());
            objStmt.setString(11, objUserInput.getTxtPatientHPN());
            objStmt.setString(12, objUserInput.getTxtPatientWPN());
            objStmt.setString(13, objUserInput.getTxtPatientCPN());
            objStmt.setString(14, objUserInput.getTxtPatientStreet());
            objStmt.setString(15, objUserInput.getTxtPatientCity());
            objStmt.setString(16, objUserInput.getTxtPatientRegion());
            objStmt.setString(17, objUserInput.getTxtPatientZipCode());
            objStmt.setString(18, objUserInput.getTxtPatientPO());
            objStmt.setString(19, objUserInput.getTxtPatientProvince());
            objStmt.setString(20, objUserInput.getTxtPatientEthnicity());
            objStmt.setString(21, objUserInput.getTxtPatientRace());
            objStmt.setString(22, objUserInput.getTxtPatientOccupation());
            objStmt.setString(23, objUserInput.getTxtPatientEmployer());
            objStmt.setString(24, objUserInput.getTxtPatientEmployerPN());
            objStmt.setString(25, objUserInput.getTxtPatientECName());
            objStmt.setString(26, objUserInput.getTxtPatientToEC());
            objStmt.setString(27, objUserInput.getTxtPatientECPhoneNumber());
            objStmt.setString(28, "Yes");
            objStmt.setString(29, strPatientSSN);

            int intRowsAffected = objStmt.executeUpdate();

            if (intRowsAffected == 0) {
                throw new SQLException("Update failed - patient with SSN " + strPatientSSN + " not found.");
            }
        }
    }
}
