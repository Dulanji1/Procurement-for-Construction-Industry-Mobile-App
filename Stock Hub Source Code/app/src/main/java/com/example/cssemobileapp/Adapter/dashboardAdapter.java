package com.example.cssemobileapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.R;
import com.example.cssemobileapp.Holder.dashboardHolder;

import java.util.ArrayList;

public class dashboardAdapter extends RecyclerView.Adapter<dashboardHolder> {

    Context c;
    ArrayList<dashboardModel> models;
    CardView cardView;

    public dashboardAdapter(Context c, ArrayList<dashboardModel> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public dashboardHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, null);
        cardView = (CardView) view;
        return new dashboardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dashboardHolder holder, int i) {
        holder.surveyName.setText(models.get(i).getSurveyName());
        holder.CreatedDate.setText(models.get(i).getCreatedDate());
        holder.Submissions.setText(models.get(i).getSubmissions());
        holder.questions.setText(models.get(i).getQuestions());
        holder.pages.setText(models.get(i).getPages());

    }

    @Override
    public int getItemCount() {
        if (models == null) return 0;
        else
            return models.size();
    }
}

