package com.example.appcovidlapiedad.fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.appcovidlapiedad.ConexionSQLiteHelper;
import com.example.appcovidlapiedad.DetallesHospital;
import com.example.appcovidlapiedad.R;
import com.example.appcovidlapiedad.adaptaciones.ListaHospitalesAdapter;
import com.example.appcovidlapiedad.tablas.Ocupacion_hospitales;
import com.example.appcovidlapiedad.tablas.detalles_hospitales;
import com.example.appcovidlapiedad.tablas.ubicacion_hospitales;
import com.example.appcovidlapiedad.utilidades.Utilidades;

import java.util.ArrayList;

public class ListadoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    //RECYCLER VIEW Y BASE DE DATOS
    RecyclerView recyclerHospitales;
    ArrayList<Ocupacion_hospitales> listaHospitales;
    ArrayList<detalles_hospitales> listaDetalles;
    ArrayList<ubicacion_hospitales> listaUbicaciones;
    ConexionSQLiteHelper conn;

    public ListadoFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ListadoFragment newInstance(String param1, String param2) {
        ListadoFragment fragment = new ListadoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_listado, container, false);

        //Conexi??n a la BD
        conn = new ConexionSQLiteHelper(getContext());

        listaHospitales = new ArrayList<>();
        listaDetalles = new ArrayList<>();
        listaUbicaciones = new ArrayList<>();

        recyclerHospitales = (RecyclerView) vista.findViewById(R.id.recyclerHospitales);
        recyclerHospitales.setLayoutManager(new LinearLayoutManager(getContext()));

        //M??todo para consultar los hospitales de la tabla Ocupacion_hospitales
        consultarHospitales();

        //M??todo para consultar los detalles de la tabla detalles_hospitales
        consultarDetalles();

        //M??todo para consultar la latitud y longitud de la tabla ubicacion_hospitales
        consultarUbicacion();

        //Adapter para el RecyclerView
        ListaHospitalesAdapter adapter = new ListaHospitalesAdapter(listaHospitales, listaDetalles, listaUbicaciones);


        /* adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),
                        "Tel??fono: "+listaDetalles.get(recyclerHospitales.getChildAdapterPosition(v))
                        .getTelefono()+"\n"+
                        "Direcci??n: "+listaDetalles.get(recyclerHospitales.getChildAdapterPosition(v))
                        .getDireccion(),Toast.LENGTH_SHORT).show();
            }
        }); */

        recyclerHospitales.setAdapter(adapter);

        return vista;
    }

    private void consultarHospitales(){
        SQLiteDatabase db = conn.getReadableDatabase();

        Ocupacion_hospitales hospital = null;

        //Consulta para obtener todos los campos de la tabla ocupacion_hospitales ordenados por el porcentaje de ocupaci??n
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_OCUPACION_HOSPITALES
                                      + " ORDER BY "+ Utilidades.CAMPO_PORCENTAJE_OCUPACION +" ASC",null);

        while (cursor.moveToNext()){
            hospital = new Ocupacion_hospitales();
            hospital.setNombre(cursor.getString(1));
            hospital.setPorcentaje_ocupacion(cursor.getInt(2));

            listaHospitales.add(hospital);
        }
    }

    private void consultarDetalles(){
        SQLiteDatabase db = conn.getReadableDatabase();

        detalles_hospitales detalles = null;

        //Consulta para obtener el id, la direcci??n y el tel??fono, ordenados por el porcentaje de ocupaci??n
        Cursor cursor = db.rawQuery("SELECT dh.id, direccion, telefono " +
                                        "FROM "+ Utilidades.TABLA_DETALLES_HOSPITALES + " AS dh " +
                                        "JOIN ocupacion_hospitales AS oh ON (id_hospital = oh.id) " +
                                        "ORDER BY porcentaje_ocupacion ASC",null);

        while (cursor.moveToNext()){
            detalles = new detalles_hospitales();
            detalles.setDireccion(cursor.getString(1));
            detalles.setTelefono(cursor.getString(2));

            listaDetalles.add(detalles);
        }
    }

    private void consultarUbicacion(){
        SQLiteDatabase db = conn.getReadableDatabase();

        ubicacion_hospitales ubicacion = null;

        //Consulta para obtener el id, la latitud y longitud, ordenados por el porcentaje de ocupaci??n
        Cursor cursor = db.rawQuery("SELECT uh.id, latitud, longitud " +
                "FROM "+ Utilidades.TABLA_UBICACION_HOSPITALES + " AS uh " +
                "JOIN ocupacion_hospitales AS oh ON (id_hospital = oh.id) " +
                "ORDER BY porcentaje_ocupacion ASC",null);

        while (cursor.moveToNext()){
            ubicacion = new ubicacion_hospitales();
            ubicacion.setLatitud(cursor.getDouble(1));
            ubicacion.setLongitud(cursor.getDouble(2));

            listaUbicaciones.add(ubicacion);
        }
    }

}