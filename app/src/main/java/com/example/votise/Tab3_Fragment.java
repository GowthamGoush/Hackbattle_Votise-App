package com.example.votise;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Tab3_Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Tab3_Fragment() {
        // Required empty public constructor
    }

    public static Tab3_Fragment newInstance(String param1, String param2) {
        Tab3_Fragment fragment = new Tab3_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private RecyclerView recyclerView;
    private Recycler_Adapter_News adapter;
    private ArrayList<NewsFeedData> News;

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

        View root = inflater.inflate(R.layout.fragment_tab3_, container, false);

        recyclerView = root.findViewById(R.id.newsFeedRecycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        News = new ArrayList<>();

        News.add(new NewsFeedData("No pressure politics","India News: The Shiv Sena has said there was no pressure politics by the Congress after Sonia Gandhi wrote a letter to Uddhav Thackeray seeking welfare measures",
                "The Times of India",
                "https://static.toiimg.com/thumb/msid-79812213,width-640,height-360,imgsize-662346,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg",
                "https://timesofindia.indiatimes.com/india/no-pressure-politics-shiv-sena-on-sonias-letter-to-uddhav-thackeray/articleshow/79811835.cms"));

        News.add(new NewsFeedData("No pressure politics","India News: The Shiv Sena has said there was no pressure politics by the Congress after Sonia Gandhi wrote a letter to Uddhav Thackeray seeking welfare measures",
                "The Times of India",
                "https://static.toiimg.com/thumb/msid-79812213,width-640,height-360,imgsize-662346,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg",
                "https://timesofindia.indiatimes.com/india/no-pressure-politics-shiv-sena-on-sonias-letter-to-uddhav-thackeray/articleshow/79811835.cms"));

        News.add(new NewsFeedData("No pressure politics","India News: The Shiv Sena has said there was no pressure politics by the Congress after Sonia Gandhi wrote a letter to Uddhav Thackeray seeking welfare measures",
                "The Times of India",
                "https://static.toiimg.com/thumb/msid-79812213,width-640,height-360,imgsize-662346,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg",
                "https://timesofindia.indiatimes.com/india/no-pressure-politics-shiv-sena-on-sonias-letter-to-uddhav-thackeray/articleshow/79811835.cms"));

        News.add(new NewsFeedData("No pressure politics","India News: The Shiv Sena has said there was no pressure politics by the Congress after Sonia Gandhi wrote a letter to Uddhav Thackeray seeking welfare measures",
                "The Times of India",
                "https://static.toiimg.com/thumb/msid-79812213,width-640,height-360,imgsize-662346,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg",
                "https://timesofindia.indiatimes.com/india/no-pressure-politics-shiv-sena-on-sonias-letter-to-uddhav-thackeray/articleshow/79811835.cms"));


        News.add(new NewsFeedData("No pressure politics","India News: The Shiv Sena has said there was no pressure politics by the Congress after Sonia Gandhi wrote a letter to Uddhav Thackeray seeking welfare measures",
                "The Times of India",
                "https://static.toiimg.com/thumb/msid-79812213,width-640,height-360,imgsize-662346,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg",
                "https://timesofindia.indiatimes.com/india/no-pressure-politics-shiv-sena-on-sonias-letter-to-uddhav-thackeray/articleshow/79811835.cms"));


        News.add(new NewsFeedData("No pressure politics","India News: The Shiv Sena has said there was no pressure politics by the Congress after Sonia Gandhi wrote a letter to Uddhav Thackeray seeking welfare measures",
                "The Times of India",
                "https://static.toiimg.com/thumb/msid-79812213,width-640,height-360,imgsize-662346,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg",
                "https://timesofindia.indiatimes.com/india/no-pressure-politics-shiv-sena-on-sonias-letter-to-uddhav-thackeray/articleshow/79811835.cms"));

        adapter = new Recycler_Adapter_News(News,getContext(),getActivity());
        recyclerView.setAdapter(adapter);

        return root;
    }
}