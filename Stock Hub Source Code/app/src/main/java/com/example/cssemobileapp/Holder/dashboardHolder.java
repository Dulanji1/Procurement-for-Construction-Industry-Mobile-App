package com.example.cssemobileapp.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.R;

public class dashboardHolder extends RecyclerView.ViewHolder {

    public TextView surveyName;
    public TextView CreatedDate;
    public TextView Submissions;
    public TextView questions;
    public TextView pages;
    public dashboardHolder(@NonNull View itemView) {
        super(itemView);

        this.surveyName = itemView.findViewById(R.id.surveyName);
        this.CreatedDate = itemView.findViewById(R.id.createdDate);
        this.Submissions = itemView.findViewById(R.id.submissions);
        this.questions = itemView.findViewById(R.id.questions);
        this.pages = itemView.findViewById(R.id.pages);
    }
}
