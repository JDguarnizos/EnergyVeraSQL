package com.energyvera.service;

import com.energyvera.dao.GarantiaDAO;
import com.energyvera.daoImpl.GarantiaDAOImpl;
import com.energyvera.model.garantia;
import java.util.List;

public class garantiaService {
    
    private GarantiaDAO garantiaDAO;

    public garantiaService() {
        this.garantiaDAO = new GarantiaDAOImpl();
    }

    // Registrar nueva garantía
    public void registrarGarantia(garantia gar) {
        garantiaDAO.insertar(gar);
    }

    // Actualizar garantía existente
    public void actualizarGarantia(garantia gar) {
        garantiaDAO.actualizar(gar);
    }

    // Eliminar garantía por ID
    public void eliminarGarantia(int id) {
        garantiaDAO.eliminar(id);
    }

    // Buscar una garantía por ID
    public garantia buscarGarantiaPorId(int id) {
        return garantiaDAO.obtenerPorId(id);
    }

    // Listar todas las garantías
    public List<garantia> listarGarantias() {
        return garantiaDAO.obtenerTodos();
    }
}
