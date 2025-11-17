
package com.energyvera.service;

import com.energyvera.dao.FacturaCompraDAO;
import com.energyvera.daoImpl.FacturaCompraDAOImpl;
import com.energyvera.model.facturaCompra;
import java.util.List;

public class facturaCompraService {
    
    private FacturaCompraDAO facturaCompraDAO;

    public facturaCompraService() {
        this.facturaCompraDAO = new FacturaCompraDAOImpl();
    }

    public void registrarFacturaCompra(facturaCompra fc) {
        facturaCompraDAO.insertar(fc);
    }

    public void actualizarFacturaCompra(facturaCompra fc) {
        facturaCompraDAO.actualizar(fc);
    }

    public void eliminarFacturaCompra(int id) {
        facturaCompraDAO.eliminar(id);
    }

    public facturaCompra buscarFacturaCompraPorId(int id) {
        return facturaCompraDAO.obtenerPorId(id);
    }

    public List<facturaCompra> listarFacturasCompra() {
        return facturaCompraDAO.obtenerTodos();
    }
}
