package sqlcodes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import database.DatabaseConnection;

public class Two {

    public static DefaultTableModel fetchPatientDemographics() {
        String[] strColumnNames = {
            "Patient SSN",
            "Registration Date",
            "Previous Physician",
            "Last Name",
            "First Name",
            "Middle Name",
            "Honorifics",
            "Birthdate",
            "Age",
            "Gender",
            "Marital Status",
            "Home Phone",
            "Work Phone",
            "Cell Phone",
            "Street/Barangay",
            "City",
            "Region",
            "Zip Code",
            "PO Box",
            "Province",
            "Ethnicity",
            "Race",
            "Occupation",
            "Employer",
            "Employer Phone",
            "Emergency Contact",
            "EC Relation",
            "EC Phone",
            "Guardian Authorization"
        };

        @SuppressWarnings("serial")
        DefaultTableModel tblModel = new DefaultTableModel(strColumnNames, 0) {
            @Override
            public boolean isCellEditable(int intRow, int intColumn) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int intColumnIndex) {
                switch (intColumnIndex) {
                    case 1: return Date.class;    
                    case 7: return Date.class;    
                    case 8: return Integer.class; 
                    default: return String.class;
                }
            }
        };

        String strSQL = "SELECT * FROM patient_info WHERE p_lastname = 'Reyes'";

        try (Connection objConn = DatabaseConnection.getConnection();
             Statement objStmt = objConn.createStatement();
             ResultSet objRS = objStmt.executeQuery(strSQL)) {

            while (objRS.next()) {
                Object[] objRow = {
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
                tblModel.addRow(objRow);
            }
        } catch (SQLException objSqlEx) {
            objSqlEx.printStackTrace();
            return new DefaultTableModel(strColumnNames, 0);
        }

        return tblModel;
    }
}