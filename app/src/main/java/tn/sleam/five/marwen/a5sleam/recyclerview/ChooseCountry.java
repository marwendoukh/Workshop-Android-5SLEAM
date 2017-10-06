package tn.sleam.five.marwen.a5sleam.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import tn.sleam.five.marwen.a5sleam.R;

public class ChooseCountry extends AppCompatActivity {

    Spinner chooseCountry;
    Button showUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_country);

        chooseCountry = (Spinner) findViewById(R.id.spinner_choose_country);

        showUsers = (Button) findViewById(R.id.show_user_list);

        // set listner on the button
        showUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //prepare the new intent
                Intent i = new Intent(getApplicationContext(), UsersList.class);
                // put the chosen country in Extra
                i.putExtra("country", chooseCountry.getSelectedItem().toString());
                // launch the activity that will show the users list
                startActivity(i);
            }
        });
    }
}
