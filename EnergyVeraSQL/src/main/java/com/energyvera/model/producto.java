package com.energyvera.model;

public class producto {

    private int idProducto;
    private String marca;
    private double precio;
    private int stock;
    private String tipo;


    public producto() {
    }

    public producto(int idProducto, String marca, String descripcion, double precio, int idProveedor, int stock, int tipo) {
        this.idProducto = idProducto;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo= tipo;
    }
    @Override

    public String toString() {
        return "Producto:\n"
                + "  ID: " + idProducto + "\n"
                + "  Marca: " + marca + "\n"
                + "  Tipo: " + tipo;
    }

}
