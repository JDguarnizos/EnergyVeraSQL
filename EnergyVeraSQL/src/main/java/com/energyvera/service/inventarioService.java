package com.energyvera.service;

import com.energyvera.dao.InventarioDAO;
import com.energyvera.model.inventario;
import java.util.List;

public class inventarioService {

    private final InventarioDAO inventarioDAO;

    public inventarioService(InventarioDAO inventarioDAO) {
        this.inventarioDAO = inventarioDAO;
    }

    public void registrarInventario(inventario inv) {
        inventarioDAO.insertar(inv);
    }

    public void actualizarInventario(inventario inv) {
        inventarioDAO.actualizar(inv);
    }

    public void eliminarInventario(int idInventario) {
        inventarioDAO.eliminar(idInventario);
    }

    public inventario buscarInventario(int idInventario) {
        return inventarioDAO.obtenerPorId(idInventario);
    }

    public List<inventario> listarInventarios() {
        return inventarioDAO.obtenerTodos();
    }

    // Validación opcional
    public boolean validarUbicacion(String ubicacion) {
        return ubicacion != null && ubicacion.trim().length() >= 3;
    }
}

