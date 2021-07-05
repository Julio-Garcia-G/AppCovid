package com.example.appcovidlapiedad;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.appcovidlapiedad.tablas.Ocupacion_hospitales;
import com.example.appcovidlapiedad.tablas.ubicacion_hospitales;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.appcovidlapiedad.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Ocupacion_hospitales nombreHospital;
    private ubicacion_hospitales ubicacionHospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Se obtienen los valores del hospital seleccionado
        ubicacionHospital = (ubicacion_hospitales) getIntent().getExtras().getSerializable("ubicacion");
        nombreHospital = (Ocupacion_hospitales) getIntent().getExtras().getSerializable("nombre");

        //Se posiciona el marcador en la latitud y longitud del hospital seleccionado, el nombre se asigna como título
        //y el enfoque se coloca en la posición del hospital
        LatLng hospital = new LatLng(ubicacionHospital.getLatitud(),ubicacionHospital.getLongitud());
        mMap.addMarker(new MarkerOptions().position(hospital).title(nombreHospital.getNombre()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hospital,18));

    }
}