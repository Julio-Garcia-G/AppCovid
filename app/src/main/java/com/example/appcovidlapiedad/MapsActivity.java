package com.example.appcovidlapiedad;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

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

        // Add a marker in Sydney and move the camera
        LatLng hospital1 = new LatLng(20.3400049,-102.0241944);
        LatLng hospital2 = new LatLng(20.3460377,-102.0304524);
        LatLng hospital3 = new LatLng(20.3406483,-102.023254);
        LatLng hospital4 = new LatLng(20.3196144,-102.0150786);
        LatLng hospital5 = new LatLng(20.3464839,-102.0313109 );
        LatLng hospital6 = new LatLng(20.3495772,-102.042286 );
        LatLng hospital7 = new LatLng(20.3467158,-102.0474589 );
        LatLng hospital8 = new LatLng(20.3358657,-102.0183494 );
        LatLng hospital9 = new LatLng(20.3438666,-102.0192997);
        LatLng hospital10 = new LatLng(20.3570585,-102.0171755);

        mMap.addMarker(new MarkerOptions().position(hospital1).title(""));
        mMap.addMarker(new MarkerOptions().position(hospital2).title(""));
        mMap.addMarker(new MarkerOptions().position(hospital3).title("Centro Médico de La Piedad S.A."));
        mMap.addMarker(new MarkerOptions().position(hospital4).title(""));
        mMap.addMarker(new MarkerOptions().position(hospital5).title("Sanatorio del Carmen"));
        mMap.addMarker(new MarkerOptions().position(hospital6).title(""));
        mMap.addMarker(new MarkerOptions().position(hospital7).title(""));
        mMap.addMarker(new MarkerOptions().position(hospital8).title("Hospital San Ángel"));
        mMap.addMarker(new MarkerOptions().position(hospital9).title("Hospital Santa Margarita"));
        mMap.addMarker(new MarkerOptions().position(hospital10).title(""));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hospital1,15));
    }
}