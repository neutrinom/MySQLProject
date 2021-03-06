package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class JDBCMySQLConnection {
    private static JDBCMySQLConnection instance = new JDBCMySQLConnection();
    public static final String URL = "jdbc:mysql://localhost/jdbcdb";
    public static final String USER = "root";
    public static final String PASSWORD = "rozetka";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
 

    private JDBCMySQLConnection() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 
    private Connection createConnection() {
 
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }  
 
    public static Connection getConnection() {
        return instance.createConnection();
    }
}