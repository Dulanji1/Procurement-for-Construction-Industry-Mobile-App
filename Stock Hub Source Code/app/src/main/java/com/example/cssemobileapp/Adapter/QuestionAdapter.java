package com.example.cssemobileapp.Adapter;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.Model.Options;
import com.example.cssemobileapp.Model.Questions;
import com.example.cssemobileapp.R;
import com.example.cssemobileapp.utils.QuestionTypes;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Questions> questionList;
    private Context context;
    private Application application;

    private List<Options> options = new ArrayList<Options>();
    String[] ITEMS = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5", "Option 6"};
    ArrayAdapter<String> adapterDDL;

    public QuestionAdapter (List<Questions> _customerList,Context _context) {
        questionList = _customerList;
        context = _context;

        options.add(new Options("Option 1"));
        options.add(new Options("Option 2"));
        options.add(new Options("Option 3"));
        options.add(new Options("Option 4"));
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      if(viewType == QuestionTypes.TEXT.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_type_text, parent, false);
            return new TextViewHolder(view);
        }
        else {
          View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_type_text, parent, false);
          return new TextViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType() == QuestionTypes.TEXT.ordinal()){
            InitLayoutText((TextViewHolder)holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    @Override
    public int getItemViewType(int position) {
         if(questionList.get(position).getType() == QuestionTypes.TEXT){
            return QuestionTypes.TEXT.ordinal();
        }
        return -1;
    }


    private void InitLayoutText(TextViewHolder holder, int pos) {
        Questions customers = questionList.get(pos);
        holder.viewTxtQuestion.setText(customers.getQuestionName());
        holder.viewTxtQuestion.setTag(customers.getTimeStamp());
        holder.editTxtQuestion.setText(customers.getQuestionName());

        holder.editTxtQuestion.setVisibility(View.INVISIBLE);
        holder.layoutOptions.setVisibility(View.GONE);
    }


    // Static inner class to initialize the views of rows

    public class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        public TextView viewTxtQuestion;
        public EditText editTxtQuestion;
        public ImageButton btnEdit, btnDelete;
        public ConstraintLayout layoutOptionsView;
        public LinearLayout layoutOptions;

        public TextViewHolder(View itemView) {
            super(itemView);
            viewTxtQuestion = (TextView) itemView.findViewById(R.id.lblQuestion);
            editTxtQuestion = (EditText) itemView.findViewById(R.id.txtQuestion);

            btnEdit = (ImageButton) itemView.findViewById(R.id.btnEdit);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnDelete);

            layoutOptions = (LinearLayout) itemView.findViewById(R.id.layoutOptions);
            layoutOptionsView = (ConstraintLayout) itemView.findViewById(R.id.layoutOptionsView);


            itemView.setOnClickListener(this);
            btnEdit.setOnClickListener(this);
            btnDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == btnEdit.getId()){

                if(viewTxtQuestion.getVisibility() == View.VISIBLE){
                    viewTxtQuestion.setVisibility(View.INVISIBLE);
                    editTxtQuestion.setVisibility(View.VISIBLE);
                    layoutOptions.setVisibility(View.VISIBLE);
                    layoutOptionsView.setVisibility(View.INVISIBLE);
                    btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryConsultant), android.graphics.PorterDuff.Mode.SRC_IN);
                    return;
                }

                viewTxtQuestion.setVisibility(View.VISIBLE);
                editTxtQuestion.setVisibility(View.INVISIBLE);
                layoutOptions.setVisibility(View.GONE);
                layoutOptionsView.setVisibility(View.VISIBLE);
                btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.efab_disabled_text), android.graphics.PorterDuff.Mode.SRC_IN);

            }else if(view.getId() == btnDelete.getId()){
                new MaterialAlertDialogBuilder(context, R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Confirm to delete")
                        .setMessage("Are your sure want delete "+viewTxtQuestion.getText() + " ?")

                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int idx = 0;

                                while (idx < questionList.size())
                                {
                                    if(questionList.get(idx).getTimeStamp() == viewTxtQuestion.getTag())
                                    {
                                        // Remove item
                                        questionList.remove(idx);
                                    }
                                    else
                                    {
                                        ++idx;
                                    }
                                }
                                notifyDataSetChanged();
                            }
                        })
                        .show();
            }
        }



        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }





}
