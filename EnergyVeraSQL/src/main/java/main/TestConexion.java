
package main;

import com.energyvera.conexion.Conexion;
import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        Connection conn = Conexion.getConnection(); // Llama a tu clase Conexion

        if (conn != null) {
            System.out.println("Conexión exitosa a MySQL");
        } else {
            System.out.println("Error al conectar a MySQL");
        }
    }
}
