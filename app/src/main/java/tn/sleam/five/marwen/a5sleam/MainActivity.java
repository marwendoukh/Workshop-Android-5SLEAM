package tn.sleam.five.marwen.a5sleam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import tn.sleam.five.marwen.a5sleam.recyclerview.Main2Activity;

public class MainActivity extends AppCompatActivity {

    Button goToRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToRecyclerView = (Button) findViewById(R.id.go_to_recyclerview_course);

        goToRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
            }
        });
    }
}
