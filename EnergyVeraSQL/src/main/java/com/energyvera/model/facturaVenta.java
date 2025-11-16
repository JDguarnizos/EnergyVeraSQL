package com.energyvera.model;

import java.util.Date;

public class facturaVenta {
    
    private int idFacturaVenta;
    private Date fechaFacturaVenta;
    private double iva;
    private int idCliente;
    private int idVendedor;

    public facturaVenta() {
    }

    public facturaVenta(int idFacturaVenta, Date fechaFacturaVenta, double iva, int idCliente, int idVendedor) {
        this.idFacturaVenta = idFacturaVenta;
        this.fechaFacturaVenta = fechaFacturaVenta;
        this.iva = iva;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
    }

    public int getIdFacturaVenta() {
        return idFacturaVenta;
    }

    public void setIdFacturaVenta(int idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public Date getFechaFacturaVenta() {
        return fechaFacturaVenta;
    }

    public void setFechaFacturaVenta(Date fechaFacturaVenta) {
        this.fechaFacturaVenta = fechaFacturaVenta;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }
    
    
}
