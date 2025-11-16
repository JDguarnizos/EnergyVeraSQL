package com.energyvera.daoImpl;

import com.energyvera.dao.ClienteDAO;
import com.energyvera.model.Cliente;
import com.energyvera.conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO Cliente (Nombre, Direccion, Email) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getDireccion());
            stmt.setString(3, cliente.getEmail());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(Cliente cliente) {
        String sql = "UPDATE Cliente SET Nombre = ?, Direccion = ?, Email = ? WHERE ID_Cliente = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getDireccion());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getIdCliente());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Cliente WHERE ID_Cliente = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
    }

    @Override
    public Cliente obtenerPorId(int id) {
        String sql = "SELECT * FROM Cliente WHERE ID_Cliente = ?";
        Cliente cliente = null;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("ID_Cliente"));
                    cliente.setNombre(rs.getString("Nombre"));
                    cliente.setDireccion(rs.getString("Direccion"));
                    cliente.setEmail(rs.getString("Email"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener cliente: " + e.getMessage());
        }

        return cliente;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> lista = new ArrayList<>();

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("ID_Cliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setEmail(rs.getString("Email"));

                lista.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }

        return lista;
    }
}
