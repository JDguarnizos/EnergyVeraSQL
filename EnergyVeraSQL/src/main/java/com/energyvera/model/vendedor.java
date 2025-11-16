package com.energyvera.model;

public class vendedor {
    
    private int idVendedor;
    private String nombre;
    private String cargo;

    public vendedor() {
    }

    public vendedor(int idVendedor, String nombre, String cargo) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
    
    @Override
    public String toString(){
    return nombre + " - " + cargo + " - " + idVendedor;
    }
}
