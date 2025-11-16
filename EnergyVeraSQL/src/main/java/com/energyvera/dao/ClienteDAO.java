
package com.energyvera.dao;

import com.energyvera.model.Cliente;
import java.util.List;


public interface ClienteDAO {
    void insertar(Cliente cliente);
    void actualizar(Cliente cliente);
    void eliminar(int id);
    Cliente obtenerPorId(int id);
    List<Cliente> obtenerTodos();
}
