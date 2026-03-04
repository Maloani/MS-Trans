package com.example.mstrans;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FavorisActivity extends AppCompatActivity {

    private ArrayList<String> favorisList;
    private ArrayAdapter<String> adapter;
    private SharedPreferences preferences;
    private static final String PREF_NAME = "favorisPrefs";
    private static final String FAVORIS_KEY = "listeFavoris";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);

        EditText inputFavori = findViewById(R.id.inputFavori);
        Button btnAjouter = findViewById(R.id.btnAjouter);
        ListView listeFavoris = findViewById(R.id.listeFavoris);

        preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        favorisList = new ArrayList<>(chargerFavoris());

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, favorisList);
        listeFavoris.setAdapter(adapter);

        // Ajouter un lieu
        btnAjouter.setOnClickListener(v -> {
            String nouveauFavori = inputFavori.getText().toString().trim();
            if (!nouveauFavori.isEmpty()) {
                favorisList.add(nouveauFavori);
                enregistrerFavoris();
                adapter.notifyDataSetChanged();
                inputFavori.setText("");
                Toast.makeText(this, "Ajouté aux favoris ✅", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Entrez une adresse valide", Toast.LENGTH_SHORT).show();
            }
        });

        // Supprimer un favori par clic long
        listeFavoris.setOnItemLongClickListener((parent, view, position, id) -> {
            favorisList.remove(position);
            enregistrerFavoris();
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Favori supprimé ❌", Toast.LENGTH_SHORT).show();
            return true;
        });

        // Ouvrir dans carte intégrée (FavoriMapActivity)
        listeFavoris.setOnItemClickListener((parent, view, position, id) -> {
            String lieu = favorisList.get(position);

            new android.app.AlertDialog.Builder(this)
                    .setTitle("Navigation")
                    .setMessage("Afficher \"" + lieu + "\" sur la carte MS Trans ?")
                    .setPositiveButton("Oui", (dialog, which) -> ouvrirDansCarteMS(lieu))
                    .setNegativeButton("Non", null)
                    .show();
        });
    }

    private void ouvrirDansCarteMS(String lieu) {
        Intent intent = new Intent(FavorisActivity.this, FavoriMapActivity.class);
        intent.putExtra("lieu", lieu);
        startActivity(intent);
    }

    private void enregistrerFavoris() {
        SharedPreferences.Editor editor = preferences.edit();
        Set<String> favorisSet = new HashSet<>(favorisList);
        editor.putStringSet(FAVORIS_KEY, favorisSet);
        editor.apply();
    }

    private Set<String> chargerFavoris() {
        return preferences.getStringSet(FAVORIS_KEY, new HashSet<>());
    }
}
