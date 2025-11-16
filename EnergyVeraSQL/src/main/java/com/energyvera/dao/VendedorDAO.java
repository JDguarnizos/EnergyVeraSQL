
package com.energyvera.dao;


import com.energyvera.model.vendedor;
import java.util.List;


public interface VendedorDAO {
    void insertar(vendedor vendedor);
    void actualizar(vendedor vendedor);
    void eliminar(int id);
    vendedor obtenerPorId(int id);
    List<vendedor> obtenerTodos();
}
