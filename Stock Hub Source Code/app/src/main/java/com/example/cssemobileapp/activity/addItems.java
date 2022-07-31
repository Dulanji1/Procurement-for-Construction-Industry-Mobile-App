package com.example.cssemobileapp.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cssemobileapp.Adapter.CallBackListener;
import com.example.cssemobileapp.Adapter.QuestionAdapter;
import com.example.cssemobileapp.Model.Options;
import com.example.cssemobileapp.Model.Questions;
import com.example.cssemobileapp.R;
import com.example.cssemobileapp.utils.QuestionTypes;
import com.nambimobile.widgets.efab.FabOption;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class addItems extends Fragment implements CallBackListener {

    public List<Questions> questionList = new ArrayList<>();
    private RecyclerView recyclerView;
    private QuestionAdapter mAdapter;
    private ImageView btnPublish;

    private FabOption btnText;

    private List<Options> options = new ArrayList<Options>();

    public addItems() {
        // Required empty public constructor
    }


    public static addItems newInstance(String param1, String param2) {
        addItems fragment = new addItems();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_add_items, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_inventory);

        btnText = rootView.findViewById(R.id.btnText);

        btnPublish = rootView.findViewById(R.id.btnPublish);



        mAdapter = new QuestionAdapter(questionList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(container.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        LoadCustomerList("Question name", QuestionTypes.MULTI_CHOICE);

        btnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new PendingOrderListMain()).addToBackStack(null).addToBackStack(null).commit();
            }
        });


        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadCustomerList("Item Name", QuestionTypes.TEXT);
            }
        });



        return rootView;
    }

    @Override
    public void onDismiss() {

    }

    public void LoadCustomerList(String questionName, QuestionTypes type){
        // questionList.clear();
        String timeStamp = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));

        questionList.add(new Questions(timeStamp, questionName, options, type));
        mAdapter.notifyDataSetChanged();
    }
}