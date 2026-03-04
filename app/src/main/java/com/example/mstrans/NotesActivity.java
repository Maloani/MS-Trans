package com.example.mstrans;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NotesActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private static final String PREF_NAME = "evaluationsPrefs";
    private static final String EVAL_KEY = "listeEvaluations";

    private ArrayList<String> evaluations;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        EditText commentaireInput = findViewById(R.id.commentaireInput);
        Button btnSoumettre = findViewById(R.id.btnSoumettre);
        ListView listView = findViewById(R.id.listViewEvaluations);

        preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        evaluations = new ArrayList<>(chargerEvaluations());

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, evaluations);
        listView.setAdapter(adapter);

        btnSoumettre.setOnClickListener(v -> {
            int note = (int) ratingBar.getRating();
            String commentaire = commentaireInput.getText().toString().trim();

            if (note == 0 || commentaire.isEmpty()) {
                Toast.makeText(this, "Veuillez ajouter une note et un commentaire", Toast.LENGTH_SHORT).show();
                return;
            }

            String evaluation = "⭐ " + note + " étoile(s) : " + commentaire;
            evaluations.add(evaluation);
            enregistrerEvaluations();
            adapter.notifyDataSetChanged();

            // Reset
            ratingBar.setRating(0);
            commentaireInput.setText("");
            Toast.makeText(this, "Merci pour votre évaluation ! ✅", Toast.LENGTH_SHORT).show();
        });
    }

    private void enregistrerEvaluations() {
        SharedPreferences.Editor editor = preferences.edit();
        Set<String> set = new HashSet<>(evaluations);
        editor.putStringSet(EVAL_KEY, set);
        editor.apply();
    }

    private Set<String> chargerEvaluations() {
        return preferences.getStringSet(EVAL_KEY, new HashSet<>());
    }
}


