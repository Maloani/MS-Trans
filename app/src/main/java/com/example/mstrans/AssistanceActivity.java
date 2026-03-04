package com.example.mstrans;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AssistanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistance);

        TextView contactPhone = findViewById(R.id.contactPhone);
        TextView contactWhatsapp = findViewById(R.id.contactWhatsapp);
        TextView contactEmail = findViewById(R.id.contactEmail);
        TextView faq = findViewById(R.id.faq);

        contactPhone.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+243819036309")); // <-- Ton numéro
            startActivity(intent);
        });

        contactWhatsapp.setOnClickListener(v -> {
            String number = "+243819036309"; // ← Ton numéro WhatsApp
            String url = "https://wa.me/" + number.replace("+", "");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });

        contactEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:maloanisaidi@gmail.com")); // ← Ton email
            intent.putExtra(Intent.EXTRA_SUBJECT, "Demande d’assistance");
            startActivity(intent);
        });

        faq.setOnClickListener(v -> {
            Intent intent = new Intent(AssistanceActivity.this, FaqActivity.class);
            startActivity(intent);
        });

    }
}

