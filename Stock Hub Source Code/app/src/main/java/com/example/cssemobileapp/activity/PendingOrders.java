package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cssemobileapp.Adapter.PendingOrderAdapter;
import com.example.cssemobileapp.Model.PendingOrderModel;
import com.example.cssemobileapp.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PendingOrders#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PendingOrders extends Fragment {

    RecyclerView recyclerView;
    PendingOrderAdapter pendingOrderAdapter;
    CardView cardView;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PendingOrders() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PendingOrders.
     */
    // TODO: Rename and change types and number of parameters
    public static PendingOrders newInstance(String param1, String param2) {
        PendingOrders fragment = new PendingOrders();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: started");
        getList();

    }

    private ArrayList<PendingOrderModel> getList() {
        ArrayList<PendingOrderModel> models = new ArrayList<>();

        PendingOrderModel m = new PendingOrderModel();
        m.setPendingOrderId("1111");
        models.add(m);

        m = new PendingOrderModel();
        m.setPendingOrderId("2222");
        models.add(m);

        initRecyclerView();
        return models;
    }
    private  void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: started");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pending_orders, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view_pending_orders);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

    //    pendingOrderAdapter = new PendingOrderAdapter(getContext().getList(), getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(container.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(pendingOrderAdapter);

        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ViewPendingOrder()).addToBackStack(null).commit();

            }

        });


        return rootView;

    }
}