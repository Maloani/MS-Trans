package com.example.mstrans;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class OtpVerificationActivity extends AppCompatActivity {

    private static final String CODE_TEST = "123456"; // Code fictif pour test

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        EditText inputOtp = findViewById(R.id.inputOtp);
        Button btnValider = findViewById(R.id.btnValiderOtp);
        TextView resendOtp = findViewById(R.id.resendOtp);

        btnValider.setOnClickListener(v -> {
            String enteredCode = inputOtp.getText().toString().trim();

            if (enteredCode.equals(CODE_TEST)) {
                Toast.makeText(this, "✅ Vérification réussie", Toast.LENGTH_SHORT).show();
                // Continuer vers une autre activité sécurisée si besoin
            } else {
                Toast.makeText(this, "❌ Code incorrect", Toast.LENGTH_SHORT).show();
            }
        });

        resendOtp.setOnClickListener(v ->
                Toast.makeText(this, "📩 Nouveau code envoyé", Toast.LENGTH_SHORT).show());
    }
}

