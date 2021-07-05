package com.example.appcovidlapiedad.tablas;

import java.io.Serializable;

public class ubicacion_hospitales implements Serializable {
    private Integer id;
    private Double latitud;
    private Double longitud;

    public ubicacion_hospitales(Integer id, Double latitud, Double longitud) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public ubicacion_hospitales() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
