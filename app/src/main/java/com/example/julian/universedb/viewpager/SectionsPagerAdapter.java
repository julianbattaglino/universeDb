package com.example.julian.universedb.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Santiago Battaglino.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentoPlanetas();
            case 1:
                return new FragmentoNebulosas();
            case 2:
                return new FragmentoGalaxias();
            case 3:
                return new FragmentoConstelaciones();
            case 4:
                return new FragmentoSupernovas();
            case 5:
                return new FragmentoCometas();

            default:
                return new FragmentoPlanetas();
        }


    }

    @Override
    public int getCount() {
        return 6;
    }
}


