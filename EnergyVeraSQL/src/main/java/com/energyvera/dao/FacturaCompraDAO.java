
package com.energyvera.dao;

import com.energyvera.model.facturaCompra;
import java.util.List;


public interface FacturaCompraDAO {
    void insertar(facturaCompra facturaCompra);
    void actualizar(facturaCompra facturaCompra);
    void eliminar(int id);
    facturaCompra obtenerPorId(int id);
    List<facturaCompra> obtenerTodos();
}
