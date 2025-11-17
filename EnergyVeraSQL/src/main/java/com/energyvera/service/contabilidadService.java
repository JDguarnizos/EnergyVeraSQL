package com.energyvera.service;

import com.energyvera.dao.ContabilidadDAO;
import com.energyvera.daoImpl.ContabilidadDAOImpl;
import com.energyvera.model.contabilidad;
import java.util.List;

public class contabilidadService {
    
    
private final ContabilidadDAO contabilidadDAO;

    public contabilidadService() {
        this.contabilidadDAO = new ContabilidadDAOImpl();
    }

    public void registrar(contabilidad c) {
        contabilidadDAO.insertar(c);
    }

    public void actualizar(contabilidad c) {
        contabilidadDAO.actualizar(c);
    }

    public void eliminar(int id) {
        contabilidadDAO.eliminar(id);
    }

    public contabilidad obtenerPorId(int id) {
        return contabilidadDAO.obtenerPorId(id);
    }

    public List<contabilidad> obtenerTodos() {
        return contabilidadDAO.obtenerTodos();
    }
}
