package com.example.mstrans;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AvisActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes); // on réutilise activity_notes.xml
        Toast.makeText(this, "⭐ Bienvenue dans Avis & évaluations", Toast.LENGTH_SHORT).show();
    }
}
