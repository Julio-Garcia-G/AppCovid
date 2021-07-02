package com.example.appcovidlapiedad;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetallesHospital extends AppCompatActivity {

    TextView telefono, domicilio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_hospital);

        telefono = (TextView) findViewById(R.id.telefono);
        domicilio = (TextView) findViewById(R.id.domicilio);
    }
}
