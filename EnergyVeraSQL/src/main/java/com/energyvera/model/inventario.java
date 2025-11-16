package com.energyvera.model;

public class inventario {
    
    private int idInventario;
    private String ubicacion;

    public inventario() {
    }

    public inventario(int idInventario, String ubicacion) {
        this.idInventario = idInventario;
        this.ubicacion = ubicacion;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Inventario: " + "IDInventario:" + idInventario + ", Ubicacion:" + ubicacion + '}';
    }
    
}
