package com.energyvera.model;

import java.sql.Date;

public class garantia {
    
    private int idGarantia;
    private String motivo;
    private Date fecha;
    private int idFacturaV;

    public garantia() {
    }

    public garantia(int idGarantia, String motivo, Date fecha, int idFacturaV) {
        this.idGarantia = idGarantia;
        this.motivo = motivo;
        this.fecha = fecha;
        this.idFacturaV = idFacturaV;
    }

    public int getIdGarantia() {
        return idGarantia;
    }

    public void setIdGarantia(int idGarantia) {
        this.idGarantia = idGarantia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdFacturaV() {
        return idFacturaV;
    }

    public void setIdFacturaV(int idFacturaV) {
        this.idFacturaV = idFacturaV;
    }
    
    
}
