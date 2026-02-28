package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class SubscriberDataFetcher {

    public static DefaultTableModel fetchAllSubscriberData() {
        String[] columnNames = {
            "Subscriber SSN",
            "Subscriber Name", 
            "Birthdate",
            "Gender",
            "Employer"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        String strSQL = "SELECT " +
            "subscriber_ssn, subscriber_name, subscriber_birthdate, " +
            "subscriber_gender, subscriber_employer " +
            "FROM subscriber_info";

        try (Connection objConn = DatabaseConnection.getConnection();
             PreparedStatement objStmt = objConn.prepareStatement(strSQL);
             ResultSet objRS = objStmt.executeQuery()) {

            while (objRS.next()) {
                Object[] row = {
                    objRS.getString("subscriber_ssn"),
                    objRS.getString("subscriber_name"),
                    objRS.getDate("subscriber_birthdate"),
                    objRS.getString("subscriber_gender"),
                    objRS.getString("subscriber_employer")
                };
                tableModel.addRow(row);
            }
        } catch (SQLException objSqlEx) {
            objSqlEx.printStackTrace();
            return new DefaultTableModel(columnNames, 0);
        }

        return tableModel;
    }
}
