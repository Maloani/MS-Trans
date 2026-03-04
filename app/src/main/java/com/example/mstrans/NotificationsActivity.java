package com.example.mstrans;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class NotificationsActivity extends AppCompatActivity {

    private Switch switchSms, switchEmail, switchApp;
    private SharedPreferences prefs;
    private static final String PREFS_NAME = "notifPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        switchSms = findViewById(R.id.switchSms);
        switchEmail = findViewById(R.id.switchEmail);
        switchApp = findViewById(R.id.switchApp);
        Button btnSave = findViewById(R.id.btnSaveNotif);

        prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // Charger les valeurs enregistrées
        switchSms.setChecked(prefs.getBoolean("sms", false));
        switchEmail.setChecked(prefs.getBoolean("email", false));
        switchApp.setChecked(prefs.getBoolean("inApp", true));

        // Enregistrer les préférences
        btnSave.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("sms", switchSms.isChecked());
            editor.putBoolean("email", switchEmail.isChecked());
            editor.putBoolean("inApp", switchApp.isChecked());
            editor.apply();

            Toast.makeText(this, "Préférences enregistrées ✅", Toast.LENGTH_SHORT).show();
        });
    }
}


