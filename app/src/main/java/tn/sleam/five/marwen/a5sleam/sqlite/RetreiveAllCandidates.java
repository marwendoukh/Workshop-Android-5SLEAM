package tn.sleam.five.marwen.a5sleam.sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import tn.sleam.five.marwen.a5sleam.R;
import tn.sleam.five.marwen.a5sleam.sqlite.adapter.CandidateAdapter;
import tn.sleam.five.marwen.a5sleam.sqlite.utils.LocalStorage;

public class RetreiveAllCandidates extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retreive_all_candidates);


        // Recyclerview that will contain the list of users
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view_candidate_list);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        // organise items vertically
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rv.setItemAnimator(new DefaultItemAnimator());
        // set the Adapter and get user list from the data source
        CandidateAdapter candidateAdapter = new CandidateAdapter(LocalStorage.getInstance(getApplicationContext()).getAllCandidate());
        rv.setAdapter(candidateAdapter);

    }
}
