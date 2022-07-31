package com.example.cssemobileapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.Holder.PendingOrderHolder;
import com.example.cssemobileapp.Model.PendingOrderModel;
import com.example.cssemobileapp.R;

import java.util.ArrayList;

public class PendingOrderAdapter extends RecyclerView.Adapter<PendingOrderHolder> {

    Context c;
    ArrayList<PendingOrderModel> models;
    CardView cardView;

    public PendingOrderAdapter(Context c, ArrayList<PendingOrderModel> models) {
        this.c = c;
        this.models = models;
    }


    @NonNull
    @Override
    public PendingOrderHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, null);
        cardView = (CardView) view;
        return new PendingOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingOrderHolder holder, int i) {
        holder.pendingOrderId.setText(models.get(i).getPendingOrderId());
    }

    @Override
    public int getItemCount() {
        if (models == null) return 0;
        else
            return models.size();
    }
}
