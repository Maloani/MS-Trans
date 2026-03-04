package com.example.mstrans;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    ImageView logoSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logoSplash = findViewById(R.id.logoSplash);

        // Charger et démarrer l'animation de rotation
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        logoSplash.startAnimation(rotateAnimation);

        // Ouvrir MainActivity après 3 secondes
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, 3000); // durée (3 sec)
    }
}


