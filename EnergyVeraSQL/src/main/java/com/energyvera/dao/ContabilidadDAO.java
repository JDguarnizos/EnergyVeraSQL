
package com.energyvera.dao;

import com.energyvera.model.contabilidad;
import java.util.List;


public interface ContabilidadDAO {
    void insertar(contabilidad contabilidad);
    void actualizar(contabilidad contabilidad);
    void eliminar(int id);
    contabilidad obtenerPorId(int id);
    List<contabilidad> obtenerTodos();
}
