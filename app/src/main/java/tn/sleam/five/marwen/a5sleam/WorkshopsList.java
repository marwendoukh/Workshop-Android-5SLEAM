package tn.sleam.five.marwen.a5sleam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import tn.sleam.five.marwen.a5sleam.fragment.InitialActivityOfFragment;
import tn.sleam.five.marwen.a5sleam.recyclerview.ChooseCountry;
import tn.sleam.five.marwen.a5sleam.sensors.SensorActivity;
import tn.sleam.five.marwen.a5sleam.sqlite.AddUser;

public class WorkshopsList extends AppCompatActivity {

    Button goToRecyclerView, goToFragment, goToSensors, goToSQLITE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshops_list);


        // RecyclerView workshop
        goToRecyclerView = (Button) findViewById(R.id.go_to_recyclerview_course);
        goToRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChooseCountry.class));
            }
        });

        // Fragment workshop
        goToFragment = (Button) findViewById(R.id.go_to_fragment_course);
        goToFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), InitialActivityOfFragment.class));
            }
        });

        // Sensors workshop
        goToSensors = (Button) findViewById(R.id.go_to_sensor_course);
        goToSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SensorActivity.class));
            }
        });

        // sqlite workshop
        goToSQLITE = (Button) findViewById(R.id.go_to_sqlite_course);
        goToSQLITE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddUser.class));
            }
        });
    }
}
