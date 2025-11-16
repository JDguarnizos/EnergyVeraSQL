
package com.energyvera.dao;

import com.energyvera.model.inventario;
import java.util.List;


public interface InventarioDAO {
    void insertar(inventario inventario);
    void actualizar(inventario inventario);
    void eliminar(int id);
    inventario obtenerPorId(int id);
    List<inventario> obtenerTodos();
}
