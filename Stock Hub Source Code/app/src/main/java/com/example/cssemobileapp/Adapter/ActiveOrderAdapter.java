package com.example.cssemobileapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.Holder.ActiveOrderHolder;
import com.example.cssemobileapp.Holder.PendingOrderHolder;
import com.example.cssemobileapp.Model.ActiveOrderModel;
import com.example.cssemobileapp.Model.PendingOrderModel;
import com.example.cssemobileapp.R;
import com.example.cssemobileapp.activity.ActiveOrders;

import java.util.ArrayList;

public class ActiveOrderAdapter extends RecyclerView.Adapter<ActiveOrderHolder> {

    Context c;
    ArrayList<ActiveOrderModel> models;
    CardView cardView;

    public ActiveOrderAdapter(Context c, ArrayList<ActiveOrderModel> models) {
        this.c = c;
        this.models = models;
    }


    @NonNull
    @Override
    public ActiveOrderHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, null);
        cardView = (CardView) view;
        return new ActiveOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActiveOrderHolder holder, int i) {
        holder.activeOrderId.setText(models.get(i).getActiveOrderId());
    }

    @Override
    public int getItemCount() {
        if (models == null) return 0;
        else
            return models.size();
    }

}

