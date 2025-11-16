package com.energyvera.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

private static final String URL = "jdbc:mysql://127.0.0.1:3306/Energyvera";
private static final String USER = "root";
private static final String PASSWORD = "1012918120";


    private static Connection connection;

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexion cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion: " + e.getMessage());
        }
    }
}
