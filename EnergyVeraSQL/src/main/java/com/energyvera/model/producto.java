package com.energyvera.model;

public class producto {

    private int idProducto;
    private String marca;
    private String descripcion;
    private double precio;
    private int idProveedor;
    private int stock;
    private int tipo;

    public producto() {
    }

    public producto(int idProducto, String marca, String descripcion, double precio, int idProveedor, int stock, int tipo) {
        this.idProducto = idProducto;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idProveedor = idProveedor;
        this.stock = stock;
        this.tipo = tipo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override

    public String toString() {
        return "Producto:\n"
                + "  ID: " + idProducto + "\n"
                + "  Marca: " + marca + "\n"
                + "  Tipo: " + tipo;
    }

}
