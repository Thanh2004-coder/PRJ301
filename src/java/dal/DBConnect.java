package dal;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {
    

    
    public static Connection makeConnection() throws Exception {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=Project;User=sa;Password=thanh";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(connectionUrl);
        return con;
    }

    
    public static void main(String[] args) {
        DBConnect d = new DBConnect();
    }
}