package com.example.mstrans;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivitiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        // Initialisation des éléments
        TextView trajetsEnCours = findViewById(R.id.trajetsEnCours);
        TextView reservations = findViewById(R.id.reservations);
        TextView historique = findViewById(R.id.historique);
        TextView livraisons = findViewById(R.id.livraisons);
        TextView chat = findViewById(R.id.chat);
        TextView favoris = findViewById(R.id.favoris);
        TextView notes = findViewById(R.id.notes);
        TextView recusActivite = findViewById(R.id.recusActivite);

        // Listeners
        trajetsEnCours.setOnClickListener(v ->
                Toast.makeText(this, "🟢 Trajets en cours", Toast.LENGTH_SHORT).show());

        reservations.setOnClickListener(v ->
                Toast.makeText(this, "📅 Réservations planifiées", Toast.LENGTH_SHORT).show());

        historique.setOnClickListener(v ->
                Toast.makeText(this, "🕓 Historique des trajets", Toast.LENGTH_SHORT).show());

        livraisons.setOnClickListener(v ->
                Toast.makeText(this, "📦 Mes livraisons", Toast.LENGTH_SHORT).show());

        chat.setOnClickListener(v ->
                Toast.makeText(this, "💬 Discussions avec chauffeurs", Toast.LENGTH_SHORT).show());

        recusActivite.setOnClickListener(v ->
                Toast.makeText(this, "🧾 Reçus de trajets", Toast.LENGTH_SHORT).show());

        // Redirection vers FavorisActivity
        favoris.setOnClickListener(v -> {
            Intent intent = new Intent(ActivitiesActivity.this, FavorisActivity.class);
            startActivity(intent);
        });

        // Redirection vers NotesActivity
        notes.setOnClickListener(v -> {
            Intent intent = new Intent(ActivitiesActivity.this, NotesActivity.class);
            startActivity(intent);
        });
    }
}
