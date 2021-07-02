package com.example.appcovidlapiedad.tablas;

import java.io.Serializable;

public class detalles_hospitales implements Serializable {
    private Integer id_detalles;
    private Integer direccion;
    private Integer telefono;

    public detalles_hospitales(Integer id_detalles, Integer direccion, Integer telefono) {
        this.id_detalles = id_detalles;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Integer getId_detalles() {
        return id_detalles;
    }

    public void setId_detalles(Integer id_detalles) {
        this.id_detalles = id_detalles;
    }

    public Integer getDireccion() {
        return direccion;
    }

    public void setDireccion(Integer direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
}
