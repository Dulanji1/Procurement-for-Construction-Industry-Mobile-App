package com.example.cssemobileapp.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.R;

public class RejectedOrderHolder extends RecyclerView.ViewHolder{

    public TextView rejectedOrderId;

    public RejectedOrderHolder(@NonNull View itemView) {
        super(itemView);

        this.rejectedOrderId = itemView.findViewById(R.id.order_id);
    }
}

