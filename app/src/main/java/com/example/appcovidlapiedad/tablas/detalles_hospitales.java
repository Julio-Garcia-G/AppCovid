package com.example.appcovidlapiedad.tablas;

import java.io.Serializable;

public class detalles_hospitales implements Serializable {
    private Integer id_detalles;
    private String direccion;
    private String telefono;

    public detalles_hospitales(Integer id_detalles, String direccion, String telefono) {
        this.id_detalles = id_detalles;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public detalles_hospitales(){

    }

    public Integer getId_detalles() {
        return id_detalles;
    }

    public void setId_detalles(Integer id_detalles) {
        this.id_detalles = id_detalles;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
