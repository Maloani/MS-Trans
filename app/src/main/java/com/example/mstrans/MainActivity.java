package com.example.mstrans;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button orderTransportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // Layout avec le bouton

        orderTransportButton = findViewById(R.id.orderTransportButton);

        orderTransportButton.setOnClickListener(v -> {
            // Ouvrir MapsActivity après clic
            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intent);
        });
    }
}
