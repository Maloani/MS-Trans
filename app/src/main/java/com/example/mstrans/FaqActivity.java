package com.example.mstrans;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FaqActivity extends AppCompatActivity {

    private List<FaqItem> allFaqs;
    private List<FaqItem> filteredFaqs;
    private FaqAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        EditText searchFaq = findViewById(R.id.searchFaq);
        RecyclerView recyclerFaq = findViewById(R.id.recyclerFaq);

        allFaqs = getFaqData();
        filteredFaqs = new ArrayList<>(allFaqs);

        adapter = new FaqAdapter(filteredFaqs);
        recyclerFaq.setLayoutManager(new LinearLayoutManager(this));
        recyclerFaq.setAdapter(adapter);

        searchFaq.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterFaq(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filterFaq(String keyword) {
        filteredFaqs.clear();
        for (FaqItem faq : allFaqs) {
            if (faq.question.toLowerCase().contains(keyword.toLowerCase())) {
                filteredFaqs.add(faq);
            }
        }
        adapter.notifyDataSetChanged();
    }

    private List<FaqItem> getFaqData() {
        List<FaqItem> list = new ArrayList<>();

        list.add(new FaqItem("Comment réserver un transport ?", "Accédez à l'écran principal, choisissez un type de transport, indiquez votre destination et confirmez."));
        list.add(new FaqItem("Quels sont les moyens de paiement acceptés ?", "Vous pouvez payer via M-PESA, Orange Money, Airtel Money, ou en espèces."));
        list.add(new FaqItem("Puis-je annuler une course après réservation ?", "Oui. Vous pouvez annuler avant que le conducteur n'arrive, sans frais."));
        list.add(new FaqItem("Comment contacter le conducteur ?", "Une fois la réservation confirmée, vous verrez le numéro du conducteur."));
        list.add(new FaqItem("Est-ce que je peux réserver pour plus tard ?", "Oui. Cliquez sur 'Plus tard' et choisissez la date et l’heure."));
        list.add(new FaqItem("Comment ajouter une adresse aux favoris ?", "Appuyez longuement sur une adresse utilisée, puis sélectionnez 'Ajouter aux favoris'."));
        list.add(new FaqItem("Comment modifier mon profil ?", "Dans le menu Compte, cliquez sur 'Mon profil' pour modifier vos informations."));
        list.add(new FaqItem("Que faire si je perds un objet dans le véhicule ?", "Contactez le conducteur depuis vos activités ou contactez l’assistance MS Trans."));
        list.add(new FaqItem("Puis-je noter un chauffeur ?", "Oui, après chaque course, vous pouvez laisser une évaluation dans 'Mes évaluations'."));
        list.add(new FaqItem("Comment changer mon mot de passe ?", "Allez dans 'Sécurité' et sélectionnez 'Changer le mot de passe'."));
        list.add(new FaqItem("Comment activer les alertes de sécurité ?", "Rendez-vous dans 'Paramètres de sécurité' pour activer les alertes par SMS ou Email."));
        list.add(new FaqItem("L’application fonctionne-t-elle sans connexion internet ?", "Non, une connexion Internet est requise pour réserver et suivre les trajets."));
        list.add(new FaqItem("Y a-t-il des frais supplémentaires en heure de pointe ?", "Oui. Le prix peut varier selon l’heure et la demande."));
        list.add(new FaqItem("Puis-je commander un véhicule pour quelqu’un d’autre ?", "Oui. Il suffit d’indiquer l’adresse de départ et de fournir le contact."));
        list.add(new FaqItem("Comment puis-je obtenir une facture ?", "Les reçus sont disponibles dans le menu 'Reçus et factures' dans votre compte."));

        return list;
    }

}

