package com.example.appcovidlapiedad.utilidades;

public class Utilidades {

    //Constantes campos tabla ocupacion_hospitales
    public static final String TABLA_OCUPACION_HOSPITALES = "ocupacion_hospitales";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_PORCENTAJE_OCUPACION = "porcentaje_ocupacion";

    public static final String CREAR_TABLA_OCUPACION_HOSPITALES = "CREATE TABLE "+TABLA_OCUPACION_HOSPITALES+
                        " ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_PORCENTAJE_OCUPACION+" INTEGER)";

    //Constantes campos tabla detalles_hospitales
    public static final String TABLA_DETALLES_HOSPITALES="detalles_hospitales";
    public static final String CAMPO_ID_DETALLES="id_detalles";
    public static final String CAMPO_IMAGEN="imagen";
    public static final String CAMPO_DIRECCION="direccion";
    public static final String CAMPO_TELEFONO="telefono";

    public static final String CREAR_TABLA_DETALLES_HOSPITALES="CREATE TABLE "+TABLA_DETALLES_HOSPITALES+
                        " ("+CAMPO_ID_DETALLES+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_DIRECCION+" TEXT, "+CAMPO_TELEFONO+" INTEGER)";

}
