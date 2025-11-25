package org.example;

import java.sql.*;

public class DBConnection {
    private static Connection connection;
    public static Connection GetConnection(){
        if (connection == null){
            try {connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "zxc3FGH2yui1");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
