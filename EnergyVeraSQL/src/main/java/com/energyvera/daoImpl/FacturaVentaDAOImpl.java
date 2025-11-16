package com.energyvera.daoImpl;

import com.energyvera.dao.FacturaVentaDAO;
import com.energyvera.model.facturaVenta;
import com.energyvera.conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaVentaDAOImpl implements FacturaVentaDAO {

    @Override
    public void insertar(facturaVenta factura) {
        String sql = "INSERT INTO factura_venta (fechaFacturaVenta, iva, idCliente, idVendedor) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, factura.getFechaFacturaVenta());
            stmt.setDouble(2, factura.getIva());
            stmt.setInt(3, factura.getIdCliente());
            stmt.setInt(4, factura.getIdVendedor());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar factura de venta: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(facturaVenta factura) {
        String sql = "UPDATE factura_venta SET fechaFacturaVenta = ?, iva = ?, idCliente = ?, idVendedor = ? "
                   + "WHERE idFacturaVenta = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, factura.getFechaFacturaVenta());
            stmt.setDouble(2, factura.getIva());
            stmt.setInt(3, factura.getIdCliente());
            stmt.setInt(4, factura.getIdVendedor());
            stmt.setInt(5, factura.getIdFacturaVenta());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar factura de venta: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM factura_venta WHERE idFacturaVenta = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar factura de venta: " + e.getMessage());
        }
    }

    @Override
    public facturaVenta obtenerPorId(int id) {
        String sql = "SELECT * FROM factura_venta WHERE idFacturaVenta = ?";
        facturaVenta factura = null;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    factura = new facturaVenta();
                    factura.setIdFacturaVenta(rs.getInt("idFacturaVenta"));
                    factura.setFechaFacturaVenta(rs.getDate("fechaFacturaVenta"));
                    factura.setIva(rs.getDouble("iva"));
                    factura.setIdCliente(rs.getInt("idCliente"));
                    factura.setIdVendedor(rs.getInt("idVendedor"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener factura de venta: " + e.getMessage());
        }

        return factura;
    }

    @Override
    public List<facturaVenta> obtenerTodos() {
        String sql = "SELECT * FROM factura_venta";
        List<facturaVenta> lista = new ArrayList<>();

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                facturaVenta factura = new facturaVenta();
                factura.setIdFacturaVenta(rs.getInt("idFacturaVenta"));
                factura.setFechaFacturaVenta(rs.getDate("fechaFacturaVenta"));
                factura.setIva(rs.getDouble("iva"));
                factura.setIdCliente(rs.getInt("idCliente"));
                factura.setIdVendedor(rs.getInt("idVendedor"));

                lista.add(factura);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar facturas de venta: " + e.getMessage());
        }

        return lista;
    }
}
