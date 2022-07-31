package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.cssemobileapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddItemsForOrder#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddItemsForOrder extends Fragment {

    ImageView addnewitembtn;
    LinearLayout list;

    public AddItemsForOrder() {
        // Required empty public constructor
    }

    public static AddItemsForOrder newInstance(String param1, String param2) {
        AddItemsForOrder fragment = new AddItemsForOrder();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_items_for_order, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addnewitembtn = view.findViewById(R.id.addnewitembtn);
        list = view.findViewById(R.id.list);

        addnewitembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View journeyView = getLayoutInflater().inflate(R.layout.additemcardview,null,false);
                journeyView.findViewById(R.id.aaa);
                list.addView(journeyView);
            }
        });
    }


}