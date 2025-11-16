package com.energyvera.model;

import java.sql.Date;

public class facturaVenta {
    
    private int idFacturaV;
    private Date fechaFacturaV;
    private double iva;
    private int idCliente;
    private int idVendedor;

    public facturaVenta() {
    }

    public facturaVenta(int idFacturaVenta, Date fechaFacturaV, double iva, int idCliente, int idVendedor) {
        this.idFacturaV = idFacturaV;
        this.fechaFacturaV = fechaFacturaV;
        this.iva = iva;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
    }

    public int getIdFacturaVenta() {
        return idFacturaV;
    }

    public void setIdFacturaVenta(int idFacturaVenta) {
        this.idFacturaV = idFacturaVenta;
    }

    public Date getFechaFacturaV() {
        return fechaFacturaV;
    }

    public void setFechaFacturaV(Date fechaFacturaVenta) {
        this.fechaFacturaV = fechaFacturaVenta;
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
