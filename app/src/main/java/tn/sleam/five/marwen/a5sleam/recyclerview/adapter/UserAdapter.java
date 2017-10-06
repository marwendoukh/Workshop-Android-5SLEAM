package tn.sleam.five.marwen.a5sleam.recyclerview.adapter;

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
import tn.sleam.five.marwen.a5sleam.recyclerview.entity.User;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {


    private List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // set the name and country of each item in the list of users
        holder.name.setText(users.get(position).getName());
        holder.country.setText(users.get(position).getCountry());
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, country;

        public MyViewHolder(View view) {
            super(view);
            // textview from layout
            name = (TextView) view.findViewById(R.id.user_name_list_row);
            country = (TextView) view.findViewById(R.id.user_country_list_row);

        }
    }
}
