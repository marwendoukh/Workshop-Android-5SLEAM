package tn.sleam.five.marwen.a5sleam.sqlite.adapter;

/**
 * Created by Marwen on 01/08/17.
 */


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tn.sleam.five.marwen.a5sleam.R;
import tn.sleam.five.marwen.a5sleam.sqlite.entity.Candidate;


public class CandidateAdapter extends RecyclerView.Adapter<CandidateAdapter.MyViewHolder> {


    private List<Candidate> candidates;

    public CandidateAdapter(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.candidate_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // set the name and country of each item in the list of candidates
        holder.name.setText(candidates.get(position).getNom());
        holder.poste.setText(candidates.get(position).getPoste());
    }


    @Override
    public int getItemCount() {
        return candidates.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, poste;

        public MyViewHolder(View view) {
            super(view);
            // textview from layout
            name = (TextView) view.findViewById(R.id.candidate_name_list_row);
            poste = (TextView) view.findViewById(R.id.candidate_poste_list_row);

        }
    }
}
