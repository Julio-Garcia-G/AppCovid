package com.example.appcovidlapiedad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appcovidlapiedad.fragments.ListadoFragment;
import com.example.appcovidlapiedad.tablas.Ocupacion_hospitales;
import com.example.appcovidlapiedad.tablas.detalles_hospitales;

public class DetallesHospital extends AppCompatActivity {

    private TextView nombre, telefono, domicilio;
    private detalles_hospitales detalles;
    private Ocupacion_hospitales nombreHospital;
    private Button regresar, ubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_hospital);

        nombre = (TextView) findViewById((R.id.campoNombre));
        telefono = (TextView) findViewById(R.id.campoTelefono);
        domicilio = (TextView) findViewById(R.id.campoDomicilio);
        regresar = (Button) findViewById(R.id.boton_regresar);
        ubicacion = (Button) findViewById(R.id.boton_maps);

        //Al dar clic al botón se regresa al listado de hospitales
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetallesHospital.this,MenuLateralActivity.class);
                startActivity(intent);
            }
        });

        initValues();

        ubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetallesHospital.this,MapsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initValues(){
        detalles = (detalles_hospitales) getIntent().getExtras().getSerializable("detallesHospital");
        nombreHospital = (Ocupacion_hospitales) getIntent().getExtras().getSerializable("nombreHospital");

        telefono.setText(detalles.getTelefono());
        domicilio.setText(detalles.getDireccion());
        nombre.setText(nombreHospital.getNombre());
    }
}
