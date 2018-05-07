package com.example.lenovo.abcbuilders;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Locations extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
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
        LatLng p1 = new LatLng(28.988340, 77.022604);
        mMap.addMarker(new MarkerOptions().position(p1).title("Location 1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(p1));

        LatLng p2 = new LatLng( 28.988827, 77.024523);
        mMap.addMarker(new MarkerOptions().position(p2).title("Location 2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(p2));

        LatLng p3 = new LatLng(28.996566, 77.030639);
        mMap.addMarker(new MarkerOptions().position(p3).title("Location 3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(p3));

        LatLng p4 = new LatLng(29.000657, 77.037162);
        mMap.addMarker(new MarkerOptions().position(p4).title("Location 4"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(p4));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(p4,14.0f));


    }
}
