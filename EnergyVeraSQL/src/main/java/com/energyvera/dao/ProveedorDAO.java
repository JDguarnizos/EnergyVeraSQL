
package com.energyvera.dao;

import com.energyvera.model.proveedor;
import java.util.List;


public interface ProveedorDAO {
    void insertar(proveedor proveedor);
    void actualizar(proveedor proveedor);
    void eliminar(int id);
    proveedor obtenerPorId(int id);
    List<proveedor> obtenerTodos();
}
