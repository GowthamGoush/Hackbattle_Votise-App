package com.example.votise;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener;
import com.skydoves.powerspinner.PowerSpinnerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tab3_Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ACCESS_TOKEN = "3e518268694631132915232a9d93ac4";


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
    private RequestQueue requestQueue;
    private PowerSpinnerView  powerSpinnerView;

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
        powerSpinnerView = root.findViewById(R.id.powerSpinner_Language);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        News = new ArrayList<>();

        adapter = new Recycler_Adapter_News(News,getContext(),getActivity());
        recyclerView.setAdapter(adapter);

        requestQueue = Volley.newRequestQueue(getActivity());
        jsonNewsFeedReq("en");

        final String[] languages = {"en", "hi", "ta", "te", "ml"};

        powerSpinnerView.selectItemByIndex(0);
        powerSpinnerView.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<String>() {
            @SuppressLint("ShowToast")
            @Override public void onItemSelected(int oldIndex, @Nullable String oldItem, int newIndex, String newItem) {
                Toast.makeText(getContext(),newItem+" selected !",Toast.LENGTH_SHORT).show();
                News.clear();
                jsonNewsFeedReq(languages[newIndex]);
            }
        });
        return root;
    }

    public void jsonNewsFeedReq(String lang){

        String itemUrl = "https://gnews.io/api/v4/search?q=election&token="+ACCESS_TOKEN+"d&lang="+lang+"&country=in";

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, itemUrl, null,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("articles");

                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String title = jsonObject.getString("title");
                                String content = jsonObject.getString("description");
                                String publishedTime = jsonObject.getString("publishedAt");
                                String imageUrl = jsonObject.getString("image");
                                String newsUrl = jsonObject.getString("url");
                                News.add(new NewsFeedData(title,content,publishedTime,imageUrl,newsUrl));
                            }

                            adapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request).setTag("Req");
    }
}