package com.example.cssemobileapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.Holder.ActiveOrderHolder;
import com.example.cssemobileapp.Holder.RejectedOrderHolder;
import com.example.cssemobileapp.Model.ActiveOrderModel;
import com.example.cssemobileapp.Model.RejectedOrderModel;
import com.example.cssemobileapp.R;

import java.util.ArrayList;

public class RejectedOrderAdapter  extends RecyclerView.Adapter<RejectedOrderHolder> {

    Context c;
    ArrayList<RejectedOrderModel> models;
    CardView cardView;

    public RejectedOrderAdapter(Context c, ArrayList<RejectedOrderModel> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public RejectedOrderHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, null);
        cardView = (CardView) view;
        return new RejectedOrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RejectedOrderHolder holder, int i) {
        holder.rejectedOrderId.setText(models.get(i).getRejectedOrderId());

    }

    @Override
    public int getItemCount() {
        if (models == null) return 0;
        else
            return models.size();
    }

}

