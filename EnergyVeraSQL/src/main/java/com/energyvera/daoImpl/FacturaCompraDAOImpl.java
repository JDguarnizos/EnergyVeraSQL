package com.energyvera.daoImpl;

import com.energyvera.model.facturaCompra;
import com.energyvera.conexion.Conexion;
import com.energyvera.dao.FacturaCompraDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaCompraDAOImpl implements FacturaCompraDAO {

    @Override
    public void insertar(facturaCompra fc) {
        String sql = "INSERT INTO facturaCompra (fechaFacturaC, totalPagar) VALUES (?, ?)";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, fc.getFechaFacturaC());
            ps.setDouble(2, fc.getTotalPagar());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar factura de compra: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(facturaCompra fc) {
        String sql = "UPDATE facturaCompra SET fechaFacturaC = ?, totalPagar = ? WHERE idFacturaC = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, fc.getFechaFacturaC());
            ps.setDouble(2, fc.getTotalPagar());
            ps.setInt(3, fc.getIdFacturaC());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar factura de compra: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM facturaCompra WHERE idFacturaC = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar factura de compra: " + e.getMessage());
        }
    }

    @Override
    public facturaCompra obtenerPorId(int id) {
        String sql = "SELECT * FROM facturaCompra WHERE idFacturaC = ?";
        facturaCompra fc = null;

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                fc = new facturaCompra(
                    rs.getInt("idFacturaC"),
                    rs.getDate("fechaFacturaC"),
                    rs.getDouble("totalPagar")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener factura de compra por ID: " + e.getMessage());
        }

        return fc;
    }

    @Override
    public List<facturaCompra> obtenerTodos() {
        String sql = "SELECT * FROM facturaCompra";
        List<facturaCompra> lista = new ArrayList<>();

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                facturaCompra fc = new facturaCompra(
                    rs.getInt("idFacturaC"),
                    rs.getDate("fechaFacturaC"),
                    rs.getDouble("totalPagar")
                );
                lista.add(fc);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener todas las facturas de compra: " + e.getMessage());
        }

        return lista;
    }
}
