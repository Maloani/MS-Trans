package com.example.mstrans;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.text.InputType;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecuriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_securite);

        TextView changerMotDePasse = findViewById(R.id.changerMotDePasse);
        TextView alerteConnexion = findViewById(R.id.alerteConnexion);
        TextView alerteSMS = findViewById(R.id.alerteSMS);
        TextView alerteEmail = findViewById(R.id.alerteEmail);

        changerMotDePasse.setOnClickListener(v -> ouvrirDialogMotDePasse());
        alerteConnexion.setOnClickListener(v ->
                Toast.makeText(this, "🔔 Alerte de connexion activée", Toast.LENGTH_SHORT).show());
        alerteSMS.setOnClickListener(v ->
                Toast.makeText(this, "📩 Alertes SMS activées", Toast.LENGTH_SHORT).show());
        alerteEmail.setOnClickListener(v ->
                Toast.makeText(this, "📧 Alertes Email activées", Toast.LENGTH_SHORT).show());
    }

    private void ouvrirDialogMotDePasse() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Changer le mot de passe");

        // Zone de texte pour saisir le nouveau mot de passe
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        input.setHint("Nouveau mot de passe");

        builder.setView(input);

        builder.setPositiveButton("Valider", (dialog, which) -> {
            String newPassword = input.getText().toString().trim();
            if (!newPassword.isEmpty()) {
                Toast.makeText(this, "🔐 Mot de passe mis à jour", Toast.LENGTH_SHORT).show();
                // TODO : enregistrer ou envoyer au serveur
            } else {
                Toast.makeText(this, "Veuillez entrer un mot de passe valide", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Annuler", (dialog, which) -> dialog.cancel());
        builder.show();
    }
}

