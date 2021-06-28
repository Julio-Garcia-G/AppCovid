package com.example.appcovidlapiedad.tablas;

import java.io.Serializable;

public class Ocupacion_hospitales implements Serializable {
    private Integer id;
    private String nombre;
    private Integer porcentaje_ocupacion;

    public Ocupacion_hospitales(Integer id, String nombre, Integer porcentaje_ocupacion) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje_ocupacion = porcentaje_ocupacion;
    }

    public Ocupacion_hospitales() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPorcentaje_ocupacion() {
        return porcentaje_ocupacion;
    }

    public void setPorcentaje_ocupacion(Integer porcentaje_ocupacion) {
        this.porcentaje_ocupacion = porcentaje_ocupacion;
    }
}
