package com.energyvera.service;

import com.energyvera.dao.FacturaVentaDAO;
import com.energyvera.daoImpl.FacturaVentaDAOImpl;
import com.energyvera.model.facturaVenta;
import java.util.List;

public class facturaVentaService {

  private FacturaVentaDAO facturaVentaDAO;

    public facturaVentaService() {
        this.facturaVentaDAO = new FacturaVentaDAOImpl();
    }

    public void registrarFacturaVenta(facturaVenta fv) {
        facturaVentaDAO.insertar(fv);
    }

    public void actualizarFacturaVenta(facturaVenta fv) {
        facturaVentaDAO.actualizar(fv);
    }

    public void eliminarFacturaVenta(int id) {
        facturaVentaDAO.eliminar(id);
    }

    public facturaVenta buscarFacturaVentaPorId(int id) {
        return facturaVentaDAO.obtenerPorId(id);
    }

    public List<facturaVenta> listarFacturasVenta() {
        return facturaVentaDAO.obtenerTodos();
    }

    public List<facturaVenta> listarFacturasPorVendedor(int idVendedor) {
        return facturaVentaDAO.obtenerPorIdVendedor(idVendedor);
    }
}
