package com.example.cssemobileapp.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.R;

public class ActiveOrderHolder extends RecyclerView.ViewHolder{
    public TextView activeOrderId;

    public ActiveOrderHolder(@NonNull View itemView) {
        super(itemView);

        this.activeOrderId = itemView.findViewById(R.id.order_id);
    }
}
