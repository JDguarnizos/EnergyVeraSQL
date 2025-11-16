package com.energyvera.daoImpl;

import com.energyvera.dao.VendedorDAO;
import com.energyvera.model.vendedor;
import com.energyvera.conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAOImpl implements VendedorDAO {

    @Override
    public void insertar(vendedor vendedor) {
        String sql = "INSERT INTO vendedor (nombre, cargo) VALUES (?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vendedor.getNombre());
            stmt.setString(2, vendedor.getCargo());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar vendedor: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(vendedor vendedor) {
        String sql = "UPDATE vendedor SET nombre = ?, cargo = ? WHERE idVendedor = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vendedor.getNombre());
            stmt.setString(2, vendedor.getCargo());
            stmt.setInt(3, vendedor.getIdVendedor());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar vendedor: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM vendedor WHERE idVendedor = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar vendedor: " + e.getMessage());
        }
    }

    @Override
    public vendedor obtenerPorId(int id) {
        String sql = "SELECT * FROM vendedor WHERE idVendedor = ?";
        vendedor vend = null;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    vend = new vendedor();
                    vend.setIdVendedor(rs.getInt("idVendedor"));
                    vend.setNombre(rs.getString("nombre"));
                    vend.setCargo(rs.getString("cargo"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener vendedor: " + e.getMessage());
        }

        return vend;
    }

    @Override
    public List<vendedor> obtenerTodos() {
        String sql = "SELECT * FROM vendedor";
        List<vendedor> lista = new ArrayList<>();

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                vendedor vend = new vendedor();
                vend.setIdVendedor(rs.getInt("idVendedor"));
                vend.setNombre(rs.getString("nombre"));
                vend.setCargo(rs.getString("cargo"));

                lista.add(vend);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar vendedores: " + e.getMessage());
        }

        return lista;
    }
}
