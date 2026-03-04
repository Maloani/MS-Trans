package com.example.mstrans;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        // Initialisation des éléments
        TextView monProfil = findViewById(R.id.monProfil);
        TextView moyenPaie = findViewById(R.id.moyenPaie);
        TextView mesCommandes = findViewById(R.id.mesCommandes);
        TextView mesAvis = findViewById(R.id.mesAvis);
        TextView securite = findViewById(R.id.securite);
        TextView notifications = findViewById(R.id.notifications);
        TextView recus = findViewById(R.id.recus);
        TextView aide = findViewById(R.id.aide);
        TextView seDeconnecter = findViewById(R.id.seDeconnecter);

        // Navigation ou Toast
        monProfil.setOnClickListener(v ->
                Toast.makeText(this, "👤 Mon profil", Toast.LENGTH_SHORT).show());

        moyenPaie.setOnClickListener(v ->
                Toast.makeText(this, "💳 Moyens de paiement", Toast.LENGTH_SHORT).show());

        mesCommandes.setOnClickListener(v ->
                Toast.makeText(this, "📦 Mes commandes", Toast.LENGTH_SHORT).show());

        mesAvis.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, AvisActivity.class);
            startActivity(intent);
        });

        securite.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, SecuriteActivity.class);
            startActivity(intent);
        });

        notifications.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, NotificationsActivity.class);
            startActivity(intent);
        });

        aide.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, AssistanceActivity.class);
            startActivity(intent);
        });

        recus.setOnClickListener(v ->
                Toast.makeText(this, "🧾 Reçus et factures", Toast.LENGTH_SHORT).show());

        seDeconnecter.setOnClickListener(v ->
                Toast.makeText(this, "🚪 Déconnexion...", Toast.LENGTH_SHORT).show());
    }
}
