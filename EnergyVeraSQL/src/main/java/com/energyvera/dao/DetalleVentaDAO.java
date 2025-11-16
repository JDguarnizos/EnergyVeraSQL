
package com.energyvera.dao;

import com.energyvera.model.detalleVenta;
import java.util.List;


public interface DetalleVentaDAO {
    void insertar(detalleVenta detalleVenta);
    void actualizar(detalleVenta detalleVenta);
    void eliminar(int id);
    detalleVenta obtenerPorId(int id);
    List<detalleVenta> obtenerTodos();
}
