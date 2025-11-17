package com.energyvera.daoImpl;

import com.energyvera.model.garantia;
import com.energyvera.conexion.Conexion;
import com.energyvera.dao.GarantiaDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GarantiaDAOImpl implements GarantiaDAO {

    @Override
    public void insertar(garantia garantia) {
        String sql = "INSERT INTO garantia (motivo, fecha, idFacturaV) VALUES (?, ?, ?)";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, garantia.getMotivo());
            ps.setDate(2, garantia.getFecha());
            ps.setInt(3, garantia.getIdFacturaV());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar garantía: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(garantia garantia) {
        String sql = "UPDATE garantia SET motivo = ?, fecha = ?, idFacturaV = ? WHERE idGarantia = ?";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, garantia.getMotivo());
            ps.setDate(2, garantia.getFecha());
            ps.setInt(3, garantia.getIdFacturaV());
            ps.setInt(4, garantia.getIdGarantia());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar garantía: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM garantia WHERE idGarantia = ?";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar garantía: " + e.getMessage());
        }
    }

    @Override
    public garantia obtenerPorId(int id) {
        String sql = "SELECT * FROM garantia WHERE idGarantia = ?";
        garantia gar = null;
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                gar = new garantia(
                    rs.getInt("idGarantia"),
                    rs.getString("motivo"),
                    rs.getDate("fecha"),
                    rs.getInt("idFacturaV")
                );
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener garantía por ID: " + e.getMessage());
        }
        
        return gar;
    }

    @Override
    public List<garantia> obtenerTodos() {
        String sql = "SELECT * FROM garantia";
        List<garantia> lista = new ArrayList<>();
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                garantia gar = new garantia(
                    rs.getInt("idGarantia"),
                    rs.getString("motivo"),
                    rs.getDate("fecha"),
                    rs.getInt("idFacturaV")
                );
                lista.add(gar);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al obtener todas las garantías: " + e.getMessage());
        }
        
        return lista;
    }
}
