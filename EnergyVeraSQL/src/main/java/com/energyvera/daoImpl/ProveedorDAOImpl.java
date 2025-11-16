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
        String sql = "INSERT INTO proveedor (nombre, telefono, email, direccion) VALUES (?, ?, ?, ?)";

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
        String sql = "UPDATE proveedor SET nombre = ?, telefono = ?, email = ?, direccion = ? WHERE idProveedor = ?";

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
        String sql = "DELETE FROM proveedor WHERE idProveedor = ?";

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
        String sql = "SELECT * FROM proveedor WHERE idProveedor = ?";
        proveedor prov = null;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    prov = new proveedor();
                    prov.setIdProveedor(rs.getInt("idProveedor"));
                    prov.setNombre(rs.getString("nombre"));
                    prov.setTelefono(rs.getString("telefono"));
                    prov.setEmail(rs.getString("email"));
                    prov.setDireccion(rs.getString("direccion"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener proveedor: " + e.getMessage());
        }

        return prov;
    }

    @Override
    public List<proveedor> obtenerTodos() {
        String sql = "SELECT * FROM proveedor";
        List<proveedor> lista = new ArrayList<>();

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                proveedor prov = new proveedor();
                prov.setIdProveedor(rs.getInt("idProveedor"));
                prov.setNombre(rs.getString("nombre"));
                prov.setTelefono(rs.getString("telefono"));
                prov.setEmail(rs.getString("email"));
                prov.setDireccion(rs.getString("direccion"));

                lista.add(prov);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar proveedores: " + e.getMessage());
        }

        return lista;
    }
}
