package sqlcodes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import database.DatabaseConnection;

public class Six {
    
    public static DefaultTableModel fetchPatientSubscriberRelations() {
        
        String[] strColumnNames = {
            "First Name",
            "Last Name",
            "Patient SSN",
            "Subscriber Name",
            "Relationship"
        };

        @SuppressWarnings("serial")
        DefaultTableModel tblModel = new DefaultTableModel(strColumnNames, 0) {
            @Override
            public boolean isCellEditable(int intRow, int intColumn) {
                return false; 
            }
            
            @Override
            public Class<?> getColumnClass(int intColumnIndex) {
                return String.class; 
            }
        };

        String strSQL = "SELECT pi.p_firstname, pi.p_lastname, pi.patient_ssn, " +
                        "si.subscriber_name, pi2s.S2P_relation AS relationship_to_subscriber " +
                        "FROM patient_info pi " +
                        "JOIN patient_insurance AS pi2s ON pi.patient_ssn = pi2s.patient_ssn " +
                        "JOIN subscriber_info AS si ON pi2s.subscriber_ssn = si.subscriber_ssn " +
                        "WHERE pi.patient_ssn <> pi2s.subscriber_ssn";

        try (Connection objConn = DatabaseConnection.getConnection();
             Statement objStmt = objConn.createStatement();
             ResultSet objRS = objStmt.executeQuery(strSQL)) {

            while (objRS.next()) {
                Object[] objRow = {
                    objRS.getString("p_firstname"),
                    objRS.getString("p_lastname"),
                    objRS.getString("patient_ssn"),
                    objRS.getString("subscriber_name"),
                    objRS.getString("relationship_to_subscriber")
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
