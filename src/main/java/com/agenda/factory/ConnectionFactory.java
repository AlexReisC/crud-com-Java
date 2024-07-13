package com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/agenda";

    public static Connection createConnectionToMySQL(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL not found");
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            return connection;
        } catch (SQLException e) {
            System.out.println("Database acess error");
        }
        return null;
    }

    public static void main(String[] args) {
        Connection con = createConnectionToMySQL();

        if(con != null){
            System.out.println("Conection sucess!");
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
