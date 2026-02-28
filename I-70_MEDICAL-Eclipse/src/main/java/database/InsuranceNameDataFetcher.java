package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class InsuranceNameDataFetcher {

    public static DefaultTableModel fetchAllInsuranceNameData() {
        String[] arrColumnNames = {"Insurance Code", "Insurance Provider Name"};

        @SuppressWarnings("serial")
        DefaultTableModel objTableModel = new DefaultTableModel(arrColumnNames, 0) {
            @Override
            public boolean isCellEditable(int intRow, int intColumn) {
                return false; 
            }
        };

        String strSQL = "SELECT insurance_code, insurance_name FROM insurance_name ORDER BY insurance_code";

        try (Connection objConn = DatabaseConnection.getConnection();
             Statement objStmt = objConn.createStatement();
             ResultSet objRS = objStmt.executeQuery(strSQL)) {

            while (objRS.next()) {
                objTableModel.addRow(new Object[]{
                    objRS.getString("insurance_code"),
                    objRS.getString("insurance_name")
                });
            }
        } catch (SQLException objSqlEx) {
        	objSqlEx.printStackTrace();
            return new DefaultTableModel(arrColumnNames, 0); 
        }

        return objTableModel;
    }
}
