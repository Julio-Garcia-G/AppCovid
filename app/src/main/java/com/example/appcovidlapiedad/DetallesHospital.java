package com.example.appcovidlapiedad;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appcovidlapiedad.tablas.Ocupacion_hospitales;
import com.example.appcovidlapiedad.tablas.detalles_hospitales;

public class DetallesHospital extends AppCompatActivity {

    private TextView nombre, telefono, domicilio;
    private detalles_hospitales detalles;
    private Ocupacion_hospitales nombreHospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_hospital);

        nombre = (TextView) findViewById((R.id.campoNombre));
        telefono = (TextView) findViewById(R.id.campoTelefono);
        domicilio = (TextView) findViewById(R.id.campoDomicilio);

        initValues();
    }

    private void initValues(){
        detalles = (detalles_hospitales) getIntent().getExtras().getSerializable("detallesHospital");
        nombreHospital = (Ocupacion_hospitales) getIntent().getExtras().getSerializable("nombreHospital");

        telefono.setText(detalles.getTelefono());
        domicilio.setText(detalles.getDireccion());
        nombre.setText(nombreHospital.getNombre());
    }
}
