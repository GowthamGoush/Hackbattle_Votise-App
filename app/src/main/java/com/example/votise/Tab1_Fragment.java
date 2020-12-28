package com.example.votise;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.skydoves.powerspinner.OnSpinnerItemSelectedListener;
import com.skydoves.powerspinner.PowerSpinnerView;
import com.skydoves.powerspinner.SpinnerAnimation;

import java.util.ArrayList;

public class Tab1_Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Tab1_Fragment() {
    }

    public static Tab1_Fragment newInstance(String param1, String param2) {
        Tab1_Fragment fragment = new Tab1_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private RecyclerView recyclerView;
    private Recycler_Adapter_Candidate adapter;
    private ArrayList<Candidate_Profile> Candidates;
    private PowerSpinnerView powerSpinnerView,powerSpinnerView1,powerSpinnerView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tab1_, container, false);

        powerSpinnerView = root.findViewById(R.id.powerSpinner_States);
        powerSpinnerView1 = root.findViewById(R.id.powerSpinner_District);
        powerSpinnerView2 = root.findViewById(R.id.powerSpinner_Constituency);
        recyclerView = root.findViewById(R.id.candidateRecyclerView);

        powerSpinnerView.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<String>() {
            @SuppressLint("ShowToast")
            @Override public void onItemSelected(int oldIndex, @Nullable String oldItem, int newIndex, String newItem) {
                Toast toast = Toast.makeText(getContext(),newItem+" selected !",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM,0,200);
                toast.show();
            }
        });

        powerSpinnerView1.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<String>() {
            @SuppressLint("ShowToast")
            @Override public void onItemSelected(int oldIndex, @Nullable String oldItem, int newIndex, String newItem) {
                Toast toast = Toast.makeText(getContext(),newItem+" selected !",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM,0,200);
                toast.show();
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));

        Candidates = new ArrayList<>();

        Candidates.add(new Candidate_Profile("Baskar. C","Male","IJK","Info1","Info2","Info3","Dummy"));
        Candidates.add(new Candidate_Profile("Mohan M.K.","Male","DMK","Info1","Info2","Info3","Dummy"));
        Candidates.add(new Candidate_Profile("Mallika Dayalan","Female","MDMK","Info1","Info2","Info3","Dummy"));
        Candidates.add(new Candidate_Profile("Geetha M","Female","DMK","Info1","Info2","Info3","Dummy"));
        Candidates.add(new Candidate_Profile("Amutha N","Female","NTK","Info1","Info2","Info3","Dummy"));
        Candidates.add(new Candidate_Profile("Venkatesan A E","Male","AIADMK","Info1","Info2","Info3","Dummy"));
        Candidates.add(new Candidate_Profile("Balaji S","Male","IND","Info1","Info2","Info3","Dummy"));
        Candidates.add(new Candidate_Profile("Babu S","Male","IND","Info1","Info2","Info3","Dummy"));
        Candidates.add(new Candidate_Profile("Sinthu S","Female","BJP","Info1","Info2","Info3","Dummy"));
        Candidates.add(new Candidate_Profile("Muthusamy M","Male","IND","Info1","Info2","Info3","Dummy"));
        Candidates.add(new Candidate_Profile("Sofilet","Female","LJSP","Info1","Info2","Info3","Dummy"));
        Candidates.add(new Candidate_Profile("Srinivasan","Male","IND","Info1","Info2","Info3","Dummy"));

        adapter = new Recycler_Adapter_Candidate(Candidates,getActivity());

        powerSpinnerView2.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<String>() {
            @SuppressLint("ShowToast")
            @Override public void onItemSelected(int oldIndex, @Nullable String oldItem, int newIndex, String newItem) {
                Toast toast = Toast.makeText(getContext(),newItem+" selected !",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM,0,200);
                toast.show();
                recyclerView.setAdapter(adapter);
            }
        });
        
        return root;
    }
}