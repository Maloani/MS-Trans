package com.example.mstrans;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        TextView confirmationText = findViewById(R.id.confirmationText);

        // Récupérer le type de transport choisi
        String transportType = getIntent().getStringExtra("transportType");
        confirmationText.setText("Vous avez sélectionné : " + transportType);
    }
}

