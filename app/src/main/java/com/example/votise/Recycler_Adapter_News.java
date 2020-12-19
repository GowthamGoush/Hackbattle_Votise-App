package com.example.votise;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Recycler_Adapter_News extends RecyclerView.Adapter<Recycler_Adapter_News.Frag_ViewHolder> {

    ArrayList<NewsFeedData> FragList;
    Context mContext;
    Activity mActivity;

    public class Frag_ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView1,textView2,textView3;
        public CardView cardView;
        public ImageView imageView;

        public Frag_ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.newsFeedTitle);
            textView2 = itemView.findViewById(R.id.newsFeedContent);
            textView3 = itemView.findViewById(R.id.newsFeedProvider);
            cardView = itemView.findViewById(R.id.newsFeedCard);
            imageView = itemView.findViewById(R.id.newsFeedImage);

            cardView.animate().translationZ(30f).start();

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NewsFeedData itemDetails = FragList.get(getAdapterPosition());

                    String query = itemDetails.getNewsUrl();

                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY,query);
                    mActivity.startActivity(intent);

                }
            });
        }
    }

    public Recycler_Adapter_News(ArrayList<NewsFeedData> List , Context context , Activity activity) {
        FragList = List;
        mContext = context;
        mActivity = activity;
    }

    @NonNull
    @Override
    public Frag_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_feed_layout, parent, false);
        Frag_ViewHolder fvh = new Frag_ViewHolder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(@NonNull Frag_ViewHolder holder, int position) {

        NewsFeedData Item = FragList.get(position);

        holder.textView1.setText(Item.getNewsTitle());
        holder.textView2.setText(Item.getNewsContent());
        holder.textView3.setText(Item.getNewsProvider());

        Glide.with(mContext).load(Item.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return FragList.size();
    }
}