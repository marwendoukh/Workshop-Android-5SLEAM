package tn.sleam.five.marwen.a5sleam.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import tn.sleam.five.marwen.a5sleam.R;

public class InitialActivityOfFragment extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_activity_fragment);
    }
}
