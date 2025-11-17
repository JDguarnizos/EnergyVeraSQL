package com.energyvera.daoImpl;

import com.energyvera.dao.DetalleVentaDAO;
import com.energyvera.model.detalleVenta;
import com.energyvera.conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaDAOImpl implements DetalleVentaDAO {

    @Override
    public void insertar(detalleVenta detalle) {
        String sql = "INSERT INTO DetalleVenta (ID_FacturaV, ID_Producto, Cantidad, PrecioUnitario) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, detalle.getIdFacturaV());
            ps.setInt(2, detalle.getIdProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getPrecioUnitario());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar detalle de venta: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(detalleVenta detalle) {
        String sql = "UPDATE DetalleVenta SET ID_FacturaV = ?, ID_Producto = ?, Cantidad = ?, PrecioUnitario = ? WHERE ID_Detalle = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, detalle.getIdFacturaV());
            ps.setInt(2, detalle.getIdProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getPrecioUnitario());
            ps.setInt(5, detalle.getIdDetalle());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar detalle de venta: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM DetalleVenta WHERE ID_Detalle = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar detalle de venta: " + e.getMessage());
        }
    }

    @Override
    public detalleVenta obtenerPorId(int id) {
        String sql = "SELECT * FROM DetalleVenta WHERE ID_Detalle = ?";
        detalleVenta dv = null;

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dv = new detalleVenta(
                    rs.getInt("ID_Detalle"),
                    rs.getInt("ID_FacturaV"),
                    rs.getInt("ID_Producto"),
                    rs.getInt("Cantidad"),
                    rs.getDouble("PrecioUnitario")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener detalle de venta por ID: " + e.getMessage());
        }

        return dv;
    }

    @Override
    public List<detalleVenta> obtenerTodos() {
        String sql = "SELECT * FROM DetalleVenta";
        List<detalleVenta> lista = new ArrayList<>();

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                detalleVenta dv = new detalleVenta(
                    rs.getInt("ID_Detalle"),
                    rs.getInt("ID_FacturaV"),
                    rs.getInt("ID_Producto"),
                    rs.getInt("Cantidad"),
                    rs.getDouble("PrecioUnitario")
                );

                lista.add(dv);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener todos los detalles de venta: " + e.getMessage());
        }

        return lista;
    }
}
