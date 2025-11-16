package com.energyvera.model;

import java.sql.Date;

public class contabilidad {
    
    private int idContabilidad;
    private String datosFactura;
    private Date fecha;

    public contabilidad() {
    }

    public contabilidad(int idContabilidad, String datosFactura, Date fecha) {
        this.idContabilidad = idContabilidad;
        this.datosFactura = datosFactura;
        this.fecha = fecha;
    }

    public int getIdContabilidad() {
        return idContabilidad;
    }

    public void setIdContabilidad(int idContabilidad) {
        this.idContabilidad = idContabilidad;
    }

    public String getDatosFactura() {
        return datosFactura;
    }

    public void setDatosFactura(String datosFactura) {
        this.datosFactura = datosFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
