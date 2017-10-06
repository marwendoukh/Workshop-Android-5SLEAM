package tn.sleam.five.marwen.a5sleam.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tn.sleam.five.marwen.a5sleam.R;
import tn.sleam.five.marwen.a5sleam.recyclerview.adapter.UserAdapter;
import tn.sleam.five.marwen.a5sleam.recyclerview.entity.User;
import tn.sleam.five.marwen.a5sleam.recyclerview.utils.DataSource;

public class UsersList extends AppCompatActivity {

    List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);


        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view_users_list);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rv.setItemAnimator(new DefaultItemAnimator());
        // set the Adapter and get user list from the data source
        UserAdapter usersAdapter = new UserAdapter(DataSource.getUsersByCountry(getIntent().getExtras().getString("country")));
        rv.setAdapter(usersAdapter);


    }
}
