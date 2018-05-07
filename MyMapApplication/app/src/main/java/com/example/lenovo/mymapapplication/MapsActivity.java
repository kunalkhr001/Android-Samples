package com.example.lenovo.mymapapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        LatLng India1 = new LatLng(28.998254, 77.015844);
        LatLng India2 = new LatLng(28.997475, 77.012046);
        LatLng India3 = new LatLng(29.000639, 77.014011);
        LatLng India4 = new LatLng(28.991605, 77.028498);
        LatLng India5 = new LatLng(28.990257, 77.017029);
        mMap.addMarker(new MarkerOptions().position(India1).title("DRI: 11.23"));
        mMap.addMarker(new MarkerOptions().position(India2).title("DRI: 11.42"));
        mMap.addMarker(new MarkerOptions().position(India3).title("DRI: 4.23"));
        mMap.addMarker(new MarkerOptions().position(India4).title("DRI: 12.88"));
        mMap.addMarker(new MarkerOptions().position(India5).title("DRI: 2.28"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(India1));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(India1,15.0f));
    }
}
