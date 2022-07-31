package com.example.cssemobileapp.Adapter;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.R;
import com.example.cssemobileapp.Model.Options;
import com.example.cssemobileapp.Model.Questions;

import java.util.List;

public abstract class OptionAdaptor extends RecyclerView.Adapter<OptionAdaptor.MyViewHolder> {

    private List<Options> optionsList;
    private Context context;
    private Application application;



    public OptionAdaptor(List<Options> _optionsList, Context _context){
        optionsList = _optionsList;
        context = _context;
    }

    @NonNull


    @Override
    public void onBindViewHolder(@NonNull OptionAdaptor.MyViewHolder holder, int position) {
        Options customers = optionsList.get(position);
        holder.txtOptionName.setText(customers.getName());
    }

    @Override
    public int getItemCount() {
        return optionsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

        public EditText txtOptionName;
        public ImageButton btnClose;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtOptionName = (EditText) itemView.findViewById(R.id.txtOptionName);
            btnClose = (ImageButton) itemView.findViewById(R.id.btnDelete);


            itemView.setOnClickListener(this);
            btnClose.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(view.getId() == btnClose.getId()){
                int idx = 0;

                while (idx < optionsList.size())
                {
                    if(optionsList.get(idx).getName() == txtOptionName.getText().toString())
                    {
                        // Remove item
                        optionsList.remove(idx);
                    }
                    else
                    {
                        ++idx;
                    }
                }
                notifyDataSetChanged();
            }
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
}
