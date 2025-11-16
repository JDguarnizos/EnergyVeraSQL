
package com.energyvera.dao;

import com.energyvera.model.garantia;
import java.util.List;


public interface GarantiaDAO {
    void insertar(garantia garatia);
    void actualizar(garantia garantia);
    void eliminar(int id);
    garantia obtenerPorId(int id);
    List<garantia> obtenerTodos();
}
