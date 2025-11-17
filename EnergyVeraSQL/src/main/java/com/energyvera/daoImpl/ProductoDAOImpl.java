package com.energyvera.daoImpl;

import com.energyvera.dao.ProductoDAO;
import com.energyvera.model.producto;
import com.energyvera.conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public boolean registrar(producto p) {
        String sql = "INSERT INTO Producto (Marca, Precio, Stock, Tipo) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getMarca());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getTipo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar producto: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(producto p) {
        String sql = "UPDATE Producto SET Marca = ?, Precio = ?, Stock = ?, Tipo = ? WHERE ID_Producto = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getMarca());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getTipo());
            ps.setInt(5, p.getIdProducto());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(int idProducto) {
        String sql = "DELETE FROM Producto WHERE ID_Producto = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idProducto);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }

    @Override
    public producto obtenerPorId(int idProducto) {
        String sql = "SELECT * FROM Producto WHERE ID_Producto = ?";
        producto p = null;

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idProducto);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new producto();
                    p.setIdProducto(rs.getInt("ID_Producto"));
                    p.setMarca(rs.getString("Marca"));
                    p.setPrecio(rs.getDouble("Precio"));
                    p.setStock(rs.getInt("Stock"));
                    p.setTipo(rs.getString("Tipo"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener producto: " + e.getMessage());
        }

        return p;
    }

    @Override
    public List<producto> obtenerTodos() {
        String sql = "SELECT * FROM Producto";
        List<producto> lista = new ArrayList<>();

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                producto p = new producto();
                p.setIdProducto(rs.getInt("ID_Producto"));
                p.setMarca(rs.getString("Marca"));
                p.setPrecio(rs.getDouble("Precio"));
                p.setStock(rs.getInt("Stock"));
                p.setTipo(rs.getString("Tipo"));
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }

        return lista;
    }
}
