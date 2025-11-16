package com.energyvera.model;

import java.sql.Date;

public class facturaCompra {
    
    private int idFacturaC;
    private Date fechaFacturaC;
    private double totalPagar;

    public facturaCompra() {
    }

    public facturaCompra(int idFacturaC, Date fechaFacturaC, double totalPagar) {
        this.idFacturaC = idFacturaC;
        this.fechaFacturaC = fechaFacturaC;
        this.totalPagar = totalPagar;
    }

    public int getIdFacturaC() {
        return idFacturaC;
    }

    public void setIdFacturaC(int idFacturaC) {
        this.idFacturaC = idFacturaC;
    }

    public Date getFechaFacturaC() {
        return fechaFacturaC;
    }

    public void setFechaFacturaC(Date fechaFacturaC) {
        this.fechaFacturaC = fechaFacturaC;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
    
    
}
