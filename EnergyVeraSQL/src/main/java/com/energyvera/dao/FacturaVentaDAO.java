
package com.energyvera.dao;

import com.energyvera.model.facturaVenta;
import java.util.List;


public interface FacturaVentaDAO {
    void insertar(facturaVenta facturaVenta);
    void actualizar(facturaVenta facturaVenta);
    void eliminar(int id);
    facturaVenta obtenerPorId(int id);
    List<facturaVenta> obtenerTodos();
}

