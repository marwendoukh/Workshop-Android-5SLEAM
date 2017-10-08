package tn.sleam.five.marwen.a5sleam.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import tn.sleam.five.marwen.a5sleam.R;
import tn.sleam.five.marwen.a5sleam.recyclerview.entity.User;
import tn.sleam.five.marwen.a5sleam.recyclerview.utils.DataSource;

public class AddUser extends AppCompatActivity {

    EditText userName, liveAt;
    Spinner country;
    Button addUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_add_user);


        addUser = (Button) findViewById(R.id.add_user_recyclerview);
        userName = (EditText) findViewById(R.id.user_name_recyclerview);
        liveAt = (EditText) findViewById(R.id.user_live_at_recyclerview);
        country = (Spinner) findViewById(R.id.spinner_add_country);

        // add user to the list of users
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSource.addUser(new User(userName.getText().toString(), liveAt.getText().toString()), country.getSelectedItem().toString());
                finish();
            }
        });

    }
}
