package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_schema";
    private static final String USER = "root";
    private static final String PASS = "1234";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException objEx) {
            throw new RuntimeException("JDBC Driver not found", objEx);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
