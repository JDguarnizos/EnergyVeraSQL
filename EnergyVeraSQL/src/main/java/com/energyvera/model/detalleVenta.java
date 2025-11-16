package com.energyvera.model;

public class detalleVenta {
    
    private int idDetalle;
    private int idFacturaV;
    private int idProducto;
    private int cantidad;
    private double precioUnitario;

    public detalleVenta() {
    }

    public detalleVenta(int idDetalle, int idFacturaV, int idProducto, int cantidad, double precioUnitario) {
        this.idDetalle = idDetalle;
        this.idFacturaV = idFacturaV;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdFacturaV() {
        return idFacturaV;
    }

    public void setIdFacturaV(int idFacturaV) {
        this.idFacturaV = idFacturaV;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    
}
