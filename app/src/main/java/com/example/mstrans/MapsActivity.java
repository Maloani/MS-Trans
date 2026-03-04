package com.example.mstrans;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    private static final int LOCATION_PERMISSION_CODE = 1001;

    // UI Elements
    private EditText editDestination;
    private LinearLayout btnCourse, btnMoto, btnBajaj, btnTaxi, navCompte, navActivites;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Initialiser les éléments de l’interface
        editDestination = findViewById(R.id.editDestination);
        btnCourse = findViewById(R.id.btnCourse);
        btnMoto = findViewById(R.id.btnMoto);
        btnBajaj = findViewById(R.id.btnBajaj);
        btnTaxi = findViewById(R.id.btnTaxi);
        navCompte = findViewById(R.id.navCompte);
        navActivites = findViewById(R.id.navActivites); // Ajout de ce bloc

        // Navigation vers la page Compte
        navCompte.setOnClickListener(v -> {
            Intent intent = new Intent(MapsActivity.this, AccountActivity.class);
            startActivity(intent);
        });

        // Navigation vers la page Vos Activités
        navActivites.setOnClickListener(v -> {
            Intent intent = new Intent(MapsActivity.this, ActivitiesActivity.class);
            startActivity(intent);
        });
        LinearLayout navAccueil = findViewById(R.id.navAccueil);

        navAccueil.setOnClickListener(v -> {
            Intent intent = new Intent(MapsActivity.this, SplashActivity.class);
            startActivity(intent);
            finish(); // pour ne pas revenir en arrière avec le bouton retour
        });


        // Animation + navigation vers ConfirmationActivity
        setupButton(btnCourse, "Course");
        setupButton(btnMoto, "Moto");
        setupButton(btnBajaj, "Bajaj");
        setupButton(btnTaxi, "Taxi");

        // Initialiser la carte
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    private void setupButton(LinearLayout button, String transportType) {
        button.setOnClickListener(v -> {
            v.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).withEndAction(() -> {
                v.animate().scaleX(1f).scaleY(1f).setDuration(100).start();

                Intent intent = new Intent(MapsActivity.this, ConfirmationActivity.class);
                intent.putExtra("transportType", transportType);
                startActivity(intent);
            }).start();
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_CODE);
            return;
        }

        mMap.setMyLocationEnabled(true);

        fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            if (location != null) {
                LatLng current = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(current, 14));
                mMap.addMarker(new MarkerOptions().position(current).title("Votre position"));
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == LOCATION_PERMISSION_CODE &&
                grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            recreate();
        }
    }
}
