package com.example.appcovidlapiedad;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaCarga extends AppCompatActivity {

    private AnimationDrawable animacion;
    private ImageView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);

        loading = findViewById(R.id.loading);
        loading.setBackgroundResource(R.drawable.cargando);
        animacion = (AnimationDrawable) loading.getBackground();
        animacion.start();

        //Para la pantalla de carga
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PantallaCarga.this, MenuLateralActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}