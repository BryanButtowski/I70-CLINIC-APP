import java.sql.*;
import javax.swing.*;
import java.util.Vector;

public class GetTableTesting {

    public static void main(String[] args) {
        String selectedTable = "patients"; // {PATIENT_INFO, BILLHANDLER_INFO, INSURANCE_NAME, PATIENT_INSURANCE, SUBSCRIBER INFO, HIPAA_INFO}
        new GetTableTesting().displayTableData(selectedTable);
    }

    private void displayTableData(String selectedTable) {
        String strDriver = "com.mysql.cj.jdbc.Driver";
        String strConn = "jdbc:mysql://localhost:3306/MyDb";
        String strUser = "your_username";
        String strPass = "your_password";
        String strSQL = "SELECT * FROM " + selectedTable;

        // 1. Load JDBC driver (with dedicated try-catch)
        try {
            Class.forName(strDriver);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(
                null,
                "MySQL JDBC Driver not found. Add it to your project!\n" + e.getMessage(),
                "Driver Error",
                JOptionPane.ERROR_MESSAGE
            );
            return; // Exit if driver fails
        }

        // 2. Connect to database and fetch data
        try (
            Connection objConn = DriverManager.getConnection(strConn, strUser, strPass);
            Statement objStmt = objConn.createStatement();
            ResultSet objResultSet = objStmt.executeQuery(strSQL);
        ) {
            ResultSetMetaData metaData = objResultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            Vector<String> columnNames = new Vector<>();
            Vector<Vector<Object>> data = new Vector<>();

            // Get column names
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Get row data
            while (objResultSet.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(objResultSet.getObject(i));
                }
                data.add(row);
            }

            // Display the table in Swing (on EDT)
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Table: " + selectedTable);
                JTable table = new JTable(data, columnNames);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                null,
                "Cannot connect to database. Check credentials/table name.\n" + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}