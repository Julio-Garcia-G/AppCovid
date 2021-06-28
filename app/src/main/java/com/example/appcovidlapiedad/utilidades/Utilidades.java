package com.example.appcovidlapiedad.utilidades;

public class Utilidades {

    //Constantes campos tabla ocupacion_hospitales
    public static final String TABLA_OCUPACION_HOSPITALES = "ocupacion_hospitales";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_PORCENTAJE_OCUPACION = "porcentaje_ocupacion";

    public static final String CREAR_TABLA_OCUPACION_HOSPITALES = "CREATE TABLE "+TABLA_OCUPACION_HOSPITALES+
                        " ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_PORCENTAJE_OCUPACION+" INTEGER)";


}
