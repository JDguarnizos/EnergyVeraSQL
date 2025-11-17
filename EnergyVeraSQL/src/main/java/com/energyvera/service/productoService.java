package com.energyvera.service;

import com.energyvera.dao.ProductoDAO;
import com.energyvera.daoImpl.ProductoDAOImpl;
import com.energyvera.model.producto;
import java.util.List;

public class productoService {
    private ProductoDAO productoDAO;

    public productoService() {
        this.productoDAO = new ProductoDAOImpl();
    }
    
    public boolean registrarProducto(producto p) {
        return productoDAO.registrar(p);
    }

    public boolean actualizarProducto(producto p) {
        return productoDAO.actualizar(p);
    }

    public boolean eliminarProducto(int idProducto) {
        return productoDAO.eliminar(idProducto);
    }

    public producto obtenerProductoPorId(int idProducto) {
        return productoDAO.obtenerPorId(idProducto);
    }

    public List<producto> listarProductos() {
        return productoDAO.obtenerTodos();
    }
}
