package fazConsertos.DAL;

import java.sql.*;

public class ConnectionModule {

    // Connection to MySQL db method
    public static Connection connector() {
        java.sql.Connection connection = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ML";
        String user = "root";
        String password = "";
        
        // Connecting to db
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            //System.out.println(e);
            return null;
        }
    }
}
