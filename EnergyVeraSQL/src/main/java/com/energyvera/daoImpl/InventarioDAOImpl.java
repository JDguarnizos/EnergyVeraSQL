package com.energyvera.daoImpl;

import com.energyvera.dao.InventarioDAO;
import com.energyvera.model.inventario;
import com.energyvera.conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAOImpl implements InventarioDAO {

    @Override
    public void insertar(inventario inventario) {
        String sql = "INSERT INTO Inventario (Ubicacion) VALUES (?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, inventario.getUbicacion());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar inventario: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(inventario inventario) {
        String sql = "UPDATE Inventario SET Ubicacion = ? WHERE ID_Inventario = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, inventario.getUbicacion());
            stmt.setInt(2, inventario.getIdInventario());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar inventario: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Inventario WHERE ID_Inventario = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar inventario: " + e.getMessage());
        }
    }

    @Override
    public inventario obtenerPorId(int id) {
        String sql = "SELECT * FROM Inventario WHERE ID_Inventario = ?";
        inventario inv = null;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    inv = new inventario();
                    inv.setIdInventario(rs.getInt("ID_Inventario"));
                    inv.setUbicacion(rs.getString("Ubicacion"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener inventario: " + e.getMessage());
        }

        return inv;
    }

    @Override
    public List<inventario> obtenerTodos() {
        String sql = "SELECT * FROM Inventario";
        List<inventario> lista = new ArrayList<>();

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                inventario inv = new inventario();
                inv.setIdInventario(rs.getInt("ID_Inventario"));
                inv.setUbicacion(rs.getString("Ubicacion"));

                lista.add(inv);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar inventarios: " + e.getMessage());
        }

        return lista;
    }
}
