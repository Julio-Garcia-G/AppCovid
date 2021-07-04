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
        db.execSQL(Utilidades.CREAR_TABLA_DETALLES_HOSPITALES);
        insertarDatos(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS ocupacion_hospitales");
        db.execSQL("DROP TABLE IF EXISTS detalles_hospitales");
        onCreate(db);
    }

    public void insertarDatos(SQLiteDatabase db){

        if(db != null) {
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Hospital Santa María',12)");
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Hospital de Especialidades Médicas',40)");
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Centro Médico de La Piedad S.A.',32)");
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Hospital General de La Piedad',57)");
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Sanatorio del Carmen',25)");
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Hospital General IMSS',64)");
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Clinica del ISSSTE',71)");
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Hospital San Ángel',69)");
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Hospital Santa Margarita',86)");
            db.execSQL("INSERT INTO ocupacion_hospitales (nombre,porcentaje_ocupacion) VALUES ('Centro de Salud de Santa Ana',93)");

            db.execSQL("INSERT INTO detalles_hospitales (id_hospital,direccion,telefono) VALUES (1,'Vicente Guerrero, Centro, 59300 La Piedad de Cavadas, Mich.','352 522 3108')");
            db.execSQL("INSERT INTO detalles_hospitales (id_hospital,direccion,telefono) VALUES (2,'Heriberto Jara 53, Peña, 59300 La Piedad de Cavadas, Mich.','352 522 4393')");
            db.execSQL("INSERT INTO detalles_hospitales (id_hospital,direccion,telefono) VALUES (3,'Benito Juárez, Centro, 59300 La Piedad de Cavadas, Mich.','352 522 1132')");
            db.execSQL("INSERT INTO detalles_hospitales (id_hospital,direccion,telefono) VALUES (4,'España 400, Europea, 59350 La Piedad de Cavadas, Mich.','352 521 0263')");
            db.execSQL("INSERT INTO detalles_hospitales (id_hospital,direccion,telefono) VALUES (5,'Gral. Enrique Ramírez 28, Centro, 59300 La Piedad de Cabadas, Mich.','352 522 7475')");
            db.execSQL("INSERT INTO detalles_hospitales (id_hospital,direccion,telefono) VALUES (6,'Cipres 63, Palmas, 59380 La Piedad de Cavadas, Mich.','352 526 6930')");
            db.execSQL("INSERT INTO detalles_hospitales (id_hospital,direccion,telefono) VALUES (7,'Nigromante 607, Las Carmelitas, 59374 La Piedad de Cavadas, Mich.','352 526 8415')");
            db.execSQL("INSERT INTO detalles_hospitales (id_hospital,direccion,telefono) VALUES (8,'Adolfo López Mateos Ote. 360, Centro, 59300 La Piedad de Cavadas, Mich.','352 522 6060')");
            db.execSQL("INSERT INTO detalles_hospitales (id_hospital,direccion,telefono) VALUES (9,'Av. Cuatro Milpas 112, Sta Ana Pacueco, 36910 Santa Ana Pacueco, Gto.','352 526 1557')");
            db.execSQL("INSERT INTO detalles_hospitales (id_hospital,direccion,telefono) VALUES (10,'Calle Villagrán 95, Sta Ana Pacueco, 36914 Santa Ana Pacueco, Gto.','352 526 3089')");
        }

    }
}
