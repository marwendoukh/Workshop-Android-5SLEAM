package tn.sleam.five.marwen.a5sleam.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tn.sleam.five.marwen.a5sleam.R;
import tn.sleam.five.marwen.a5sleam.sqlite.entity.Candidate;
import tn.sleam.five.marwen.a5sleam.sqlite.utils.LocalStorage;

public class AddCandidate extends AppCompatActivity {


    EditText id, nom, poste;
    Button save, retreive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_candidate);

        id = (EditText) findViewById(R.id.id_candidate_addCandidate);
        nom = (EditText) findViewById(R.id.nom_candidate_addCandidate);
        poste = (EditText) findViewById(R.id.poste_candidate_addCandidate);

        save = (Button) findViewById(R.id.save_candidate);
        retreive = (Button) findViewById(R.id.retreive_candidate);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Candidate candidate = new Candidate(Integer.parseInt(id.getText().toString()), nom.getText().toString(), poste.getText().toString());
                LocalStorage.getInstance(getApplicationContext()).saveCandidate(candidate);
                Toast.makeText(getApplicationContext(), "add successfully", Toast.LENGTH_LONG).show();
                id.setText("");
                nom.setText("");
                poste.setText("");


            }
        });


        retreive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RetreiveAllCandidates.class));
            }
        });


    }
}
