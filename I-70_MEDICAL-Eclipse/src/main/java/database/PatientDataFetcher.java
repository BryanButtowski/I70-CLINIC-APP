package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class PatientDataFetcher {

    public static DefaultTableModel fetchAllPatientData() {
        String[] columnNames = {
            "Patient SSN", "Registration Date", "Previous Physician", 
            "Last Name", "First Name", "Middle Name", "Honorifics",
            "Birthdate", "Age", "Gender", "Marital Status", 
            "Home Phone", "Work Phone", "Cell Phone",
            "Street/Barangay", "City", "Region", "Zip Code", "Po Box",
            "Province", "Ethnicity", "Race", "Occupation", "Employer",
            "Employer Phone Number", "Emergency Contact Name", "EC Relation",
            "EC Phone Number", "Patient Guardian Authorization"
        };

        DefaultTableModel objTableModel = new DefaultTableModel(columnNames, 0);

        String strSQL = "SELECT * FROM patient_info";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL);
             ResultSet objRS = objStmt.executeQuery()) {

            while (objRS.next()) {
                Object[] row = {
                    objRS.getString("patient_ssn"),
                    objRS.getDate("registration_date"),
                    objRS.getString("prev_physician"),
                    objRS.getString("p_lastname"),
                    objRS.getString("p_firstname"),
                    objRS.getString("p_middlename"),
                    objRS.getString("p_honorifics"),
                    objRS.getDate("p_birthdate"),
                    objRS.getInt("p_age"),
                    objRS.getString("p_gender"),
                    objRS.getString("p_maritalstatus"),
                    objRS.getString("p_homePN"),
                    objRS.getString("p_workPN"),
                    objRS.getString("p_cellPN"),
                    objRS.getString("p_street_brgy"),
                    objRS.getString("p_city"),
                    objRS.getString("p_region"),
                    objRS.getString("p_zipcode"),
                    objRS.getString("p_POBox"),
                    objRS.getString("p_province"),
                    objRS.getString("p_ethnicity"),
                    objRS.getString("p_race"),
                    objRS.getString("p_occupation"),
                    objRS.getString("p_employer"),
                    objRS.getString("p_employerPN"),
                    objRS.getString("EC_name"),
                    objRS.getString("E2P_relation"),
                    objRS.getString("EC_PN"),
                    objRS.getString("patient_guardian_authorization")
                };
                objTableModel.addRow(row);
            }
        } catch (SQLException objSqlEx) {
        	objSqlEx.printStackTrace();
            return new DefaultTableModel(columnNames, 0);
        }

        return objTableModel;
    }
}
