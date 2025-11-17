package com.energyvera.daoImpl;

import com.energyvera.dao.ProveedorDAO;
import com.energyvera.model.proveedor;
import com.energyvera.conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAOImpl implements ProveedorDAO {

    @Override
    public void insertar(proveedor proveedor) {
        String sql = "INSERT INTO Proveedor (Nombre, Telefono, Email, Direccion) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getTelefono());
            stmt.setString(3, proveedor.getEmail());
            stmt.setString(4, proveedor.getDireccion());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar proveedor: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(proveedor proveedor) {
        String sql = "UPDATE Proveedor SET Nombre = ?, Telefono = ?, Email = ?, Direccion = ? WHERE ID_Proveedor = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getTelefono());
            stmt.setString(3, proveedor.getEmail());
            stmt.setString(4, proveedor.getDireccion());
            stmt.setInt(5, proveedor.getIdProveedor());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar proveedor: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Proveedor WHERE ID_Proveedor = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar proveedor: " + e.getMessage());
        }
    }

    @Override
    public proveedor obtenerPorId(int id) {
        String sql = "SELECT * FROM Proveedor WHERE ID_Proveedor = ?";
        proveedor prov = null;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    prov = new proveedor();
                    prov.setIdProveedor(rs.getInt("ID_Proveedor"));
                    prov.setNombre(rs.getString("Nombre"));
                    prov.setTelefono(rs.getString("Telefono"));
                    prov.setEmail(rs.getString("Email"));
                    prov.setDireccion(rs.getString("Direccion"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener proveedor: " + e.getMessage());
        }

        return prov;
    }

    @Override
    public List<proveedor> obtenerTodos() {
        String sql = "SELECT * FROM Proveedor";
        List<proveedor> lista = new ArrayList<>();

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                proveedor prov = new proveedor();
                prov.setIdProveedor(rs.getInt("ID_Proveedor"));
                prov.setNombre(rs.getString("Nombre"));
                prov.setTelefono(rs.getString("Telefono"));
                prov.setEmail(rs.getString("Email"));
                prov.setDireccion(rs.getString("Direccion"));

                lista.add(prov);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar proveedores: " + e.getMessage());
        }

        return lista;
    }
}
