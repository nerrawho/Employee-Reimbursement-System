package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://35.193.162.63/postgres";
        //String username = System.getenv("DB_USER");
        //String password = System.getenv("DB_PASS");
        String username = "postgres";
        String password = "Password";
        return DriverManager.getConnection(url, username, password);
    }
}