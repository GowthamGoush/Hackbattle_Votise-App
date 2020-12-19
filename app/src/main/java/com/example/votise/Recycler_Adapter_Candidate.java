package com.example.votise;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycler_Adapter_Candidate extends RecyclerView.Adapter<Recycler_Adapter_Candidate.Frag1_Viewholder> {

    ArrayList<Candidate_Profile> Frag1List;
    Activity mActivity;

    public class Frag1_Viewholder extends RecyclerView.ViewHolder {

        public TextView textView1, textView2, textView3, textView4,textView5,textView6;
        public RelativeLayout expandableLayout;
        public CardView cardView;
        public ImageView imageView1, imageView2, imageView;

        public Frag1_Viewholder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.candidateName);
            textView2 = itemView.findViewById(R.id.candidateParty);
            textView3 = itemView.findViewById(R.id.candidatePosition);
            textView4 = itemView.findViewById(R.id.candidateInfo1);
            textView5 = itemView.findViewById(R.id.candidateInfo2);
            textView6 = itemView.findViewById(R.id.candidateInfo3);
            expandableLayout = itemView.findViewById(R.id.candidateCard2);
            cardView = itemView.findViewById(R.id.candidateCard1);
            imageView = itemView.findViewById(R.id.candidateImage);
            //imageView1 = itemView.findViewById(R.id.frag_attend);
            //imageView2 = itemView.findViewById(R.id.frag_bunk);


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Candidate_Profile item = Frag1List.get(getAdapterPosition());
                    item.setExpanded(!item.getExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }

    public Recycler_Adapter_Candidate(ArrayList<Candidate_Profile> List, Activity activity) {
        Frag1List = List;
        mActivity = activity;
    }

    @NonNull
    @Override
    public Frag1_Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.candidate_cards, parent, false);
        Frag1_Viewholder fvh = new Frag1_Viewholder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(@NonNull Frag1_Viewholder holder, int position) {

        Candidate_Profile Item = Frag1List.get(position);

        holder.textView1.setText(Item.getName());
        holder.textView2.setText(Item.getParty());
        holder.textView3.setText(Item.getPosition());
        holder.textView4.setText(Item.getInfo1());
        holder.textView5.setText(Item.getInfo2());
        holder.textView6.setText(Item.getInfo3());

        holder.imageView.setImageResource(R.drawable.ic_candidate);

        boolean isExpanded = Frag1List.get(position).getExpanded();

        holder.cardView.setElevation(isExpanded ? 20f : 0f);
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return Frag1List.size();
    }


}
