package com.example.mstrans;

import android.location.Geocoder;
import android.location.Address;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class FavoriMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String lieuFavori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favori_map);

        lieuFavori = getIntent().getStringExtra("lieu");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.favoriMap);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        try {
            List<Address> addresses = geocoder.getFromLocationName(lieuFavori, 1);
            if (addresses != null && !addresses.isEmpty()) {
                Address address = addresses.get(0);
                LatLng location = new LatLng(address.getLatitude(), address.getLongitude());

                mMap.addMarker(new MarkerOptions().position(location).title(lieuFavori));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
            } else {
                Toast.makeText(this, "Lieu introuvable sur la carte.", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            Toast.makeText(this, "Erreur de géocodage.", Toast.LENGTH_SHORT).show();
        }
    }
}

