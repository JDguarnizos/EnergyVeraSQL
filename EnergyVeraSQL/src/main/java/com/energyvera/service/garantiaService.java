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

    public void registrarGarantia(garantia gar) {
        garantiaDAO.insertar(gar);
    }

    public void actualizarGarantia(garantia gar) {
        garantiaDAO.actualizar(gar);
    }

    public void eliminarGarantia(int id) {
        garantiaDAO.eliminar(id);
    }

    public garantia buscarGarantiaPorId(int id) {
        return garantiaDAO.obtenerPorId(id);
    }

    public List<garantia> listarGarantias() {
        return garantiaDAO.obtenerTodos();
    }
}
