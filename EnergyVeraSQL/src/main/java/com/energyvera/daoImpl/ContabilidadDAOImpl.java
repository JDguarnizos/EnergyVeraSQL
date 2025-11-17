package com.energyvera.daoImpl;

import com.energyvera.dao.ContabilidadDAO;
import com.energyvera.model.contabilidad;
import com.energyvera.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContabilidadDAOImpl implements ContabilidadDAO {

    @Override
    public void insertar(contabilidad c) {
        String sql = "INSERT INTO contabilidad (datosFactura, fecha) VALUES (?, ?)";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getDatosFactura());
            ps.setDate(2, c.getFecha());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar contabilidad: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(contabilidad c) {
        String sql = "UPDATE contabilidad SET datosFactura = ?, fecha = ? WHERE idContabilidad = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getDatosFactura());
            ps.setDate(2, c.getFecha());
            ps.setInt(3, c.getIdContabilidad());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar contabilidad: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM contabilidad WHERE idContabilidad = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar contabilidad: " + e.getMessage());
        }
    }

    @Override
    public contabilidad obtenerPorId(int id) {
        String sql = "SELECT * FROM contabilidad WHERE idContabilidad = ?";
        contabilidad c = null;

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new contabilidad(
                    rs.getInt("idContabilidad"),
                    rs.getString("datosFactura"),
                    rs.getDate("fecha")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener contabilidad por ID: " + e.getMessage());
        }

        return c;
    }

    @Override
    public List<contabilidad> obtenerTodos() {
        String sql = "SELECT * FROM contabilidad";
        List<contabilidad> lista = new ArrayList<>();

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                contabilidad c = new contabilidad(
                    rs.getInt("idContabilidad"),
                    rs.getString("datosFactura"),
                    rs.getDate("fecha")
                );

                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener todas las contabilidades: " + e.getMessage());
        }

        return lista;
    }
}
