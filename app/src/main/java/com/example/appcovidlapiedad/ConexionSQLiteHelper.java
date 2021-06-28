package com.example.appcovidlapiedad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.appcovidlapiedad.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "app_covid";
    private static final int VERSION_BD = 1;

    public ConexionSQLiteHelper(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_OCUPACION_HOSPITALES);
        insertarDatos(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS ocupacion_hospitales");
        onCreate(db);
    }

    public void insertarDatos(SQLiteDatabase db){

        if(db != null) {
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Hospital Santa María',12)");
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Hospital de Expecialidades Médicas',40)");
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Centro Médico de La Piedad S.A.',32)");
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Hospital General de La Piedad',57)");
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Sanatorio del Carmen',25)");
        }

    }
}
