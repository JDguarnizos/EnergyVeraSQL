package com.energyvera.service;

import com.energyvera.dao.VendedorDAO;
import com.energyvera.dao.FacturaVentaDAO;
import com.energyvera.model.vendedor;
import com.energyvera.model.facturaVenta;

import java.util.List;

public class vendedorService {

    private final VendedorDAO vendedorDAO;
    private final FacturaVentaDAO facturaVentaDAO;

    public vendedorService(VendedorDAO vendedorDAO, FacturaVentaDAO facturaVentaDAO) {
        this.vendedorDAO = vendedorDAO;
        this.facturaVentaDAO = facturaVentaDAO;
    }

    public void registrarVendedor(vendedor vendedor) {
        vendedorDAO.insertar(vendedor);
    }

    public void actualizarCargos(vendedor vendedor) {
        vendedorDAO.actualizar(vendedor);
    }

    public vendedor buscarVendedor(int idVendedor) {
        return vendedorDAO.obtenerPorId(idVendedor);
    }

    public List<facturaVenta> verVentasDelVendedor(int idVendedor) {
        return facturaVentaDAO.obtenerPorIdVendedor(idVendedor);
    }
}
