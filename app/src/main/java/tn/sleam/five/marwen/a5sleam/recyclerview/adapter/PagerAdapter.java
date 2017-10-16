package tn.sleam.five.marwen.a5sleam.recyclerview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import tn.sleam.five.marwen.a5sleam.fragment.FragmentOne;
import tn.sleam.five.marwen.a5sleam.fragment.FragmentThree;
import tn.sleam.five.marwen.a5sleam.fragment.FragmentTwo;

/**
 * Created by marwen on 16/10/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    String[] titles = new String[]{"Fragment 1", "Fragment 2", "Fragment 3"};

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FragmentOne();

            case 1:
                return new FragmentTwo();

            case 2:
                return new FragmentThree();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
