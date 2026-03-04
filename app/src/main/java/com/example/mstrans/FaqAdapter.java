package com.example.mstrans;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqViewHolder> {

    private List<FaqItem> faqList;

    public FaqAdapter(List<FaqItem> faqList) {
        this.faqList = faqList;
    }

    @Override
    public FaqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faq, parent, false);
        return new FaqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FaqViewHolder holder, int position) {
        FaqItem faq = faqList.get(position);
        holder.question.setText("❓ " + faq.question);
        holder.reponse.setText(faq.reponse);

        holder.itemView.setOnClickListener(v -> {
            if (holder.reponse.getVisibility() == View.GONE) {
                holder.reponse.setVisibility(View.VISIBLE);
            } else {
                holder.reponse.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return faqList.size();
    }

    static class FaqViewHolder extends RecyclerView.ViewHolder {
        TextView question, reponse;

        FaqViewHolder(View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.faqQuestion);
            reponse = itemView.findViewById(R.id.faqAnswer);
        }
    }
}
