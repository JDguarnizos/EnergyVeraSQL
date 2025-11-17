package com.energyvera.service;

import com.energyvera.dao.ClienteDAO;
import com.energyvera.model.Cliente;
import java.util.List;

public class clienteService {

    private final ClienteDAO clienteDAO;

    public clienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public void registrarCliente(Cliente cliente) {
        clienteDAO.insertar(cliente);
    }

    public void actualizarCliente(Cliente cliente) {
        clienteDAO.actualizar(cliente);
    }

    public void eliminarCliente(int idCliente) {
        clienteDAO.eliminar(idCliente);
    }

    public Cliente buscarCliente(int idCliente) {
        return clienteDAO.obtenerPorId(idCliente);
    }

    // este sí debe validar internamente (no depende del DAO void)
    public boolean validarEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.obtenerTodos();
    }
}
