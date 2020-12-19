package com.example.votise;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

        recyclerView = root.findViewById(R.id.candidateRecyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        Candidates = new ArrayList<>();

        Candidates.add(new Candidate_Profile("Name : Rangaraj","Party : Playboys","Position : Founder","Value : 5 Cr","Properties : Infinite","Cases : 9","Dummy"));
        Candidates.add(new Candidate_Profile("Rangaraj","Playboys","Founder","Value : 5 Cr","Properties : Infinite","Cases : 9","Dummy"));
        Candidates.add(new Candidate_Profile("Rangaraj","Playboys","Founder","Value : 5 Cr","Properties : Infinite","Cases : 9","Dummy"));
        Candidates.add(new Candidate_Profile("Rangaraj","Playboys","Founder","Value : 5 Cr","Properties : Infinite","Cases : 9","Dummy"));
        Candidates.add(new Candidate_Profile("Rangaraj","Playboys","Founder","Value : 5 Cr","Properties : Infinite","Cases : 9","Dummy"));
        Candidates.add(new Candidate_Profile("Rangaraj","Playboys","Founder","Value : 5 Cr","Properties : Infinite","Cases : 9","Dummy"));
        Candidates.add(new Candidate_Profile("Rangaraj","Playboys","Founder","Value : 5 Cr","Properties : Infinite","Cases : 9","Dummy"));

        adapter = new Recycler_Adapter_Candidate(Candidates,getActivity());

        recyclerView.setAdapter(adapter);

        return root;
    }
}