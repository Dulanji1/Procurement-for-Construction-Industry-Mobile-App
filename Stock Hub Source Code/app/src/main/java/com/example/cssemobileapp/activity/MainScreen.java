package com.example.cssemobileapp.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cssemobileapp.R;


public class MainScreen extends Fragment {

    private RecyclerView recyclerViewInventory;

    private Button btn1,btn2,btn3;




    public MainScreen() {
        // Required empty public constructor
    }


    public static MainScreen newInstance(String param1, String param2) {
        MainScreen fragment = new MainScreen();

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
        View rootView = inflater.inflate(R.layout.fragment_main_screen, container, false);

        btn1 = (Button)rootView.findViewById(R.id.palceorderbn);

        btn2 = (Button)rootView.findViewById(R.id.vieworderstatusbtn);
        btn3 = (Button)rootView.findViewById(R.id.deliveryordersbtn);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new PlaceNewOrder()).addToBackStack(null).commit();

            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Home_View_Orders()).addToBackStack(null).commit();

            }

        });
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Home_Delivery()).addToBackStack(null).commit();

            }

        });


        return rootView;
    }
}