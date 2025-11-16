
package com.energyvera.dao;
import com.energyvera.model.producto;
import java.util.List;


public interface ProductoDAO {

    boolean registrar(producto p);

    boolean actualizar(producto p);

    boolean eliminar(int idProducto);

    producto obtenerPorId(int idProducto);

    List<producto> obtenerTodos();
}
