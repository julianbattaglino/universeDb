package com.example.julian.universedb;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.julian.universedb.viewpager.FragmentoCometas;
import com.example.julian.universedb.viewpager.FragmentoConstelaciones;
import com.example.julian.universedb.viewpager.FragmentoGalaxias;
import com.example.julian.universedb.viewpager.FragmentoNebulosas;
import com.example.julian.universedb.viewpager.FragmentoPlanetas;
import com.example.julian.universedb.viewpager.FragmentoSupernovas;
import com.example.julian.universedb.viewpager.SectionsPagerAdapter;


public class MainActivity extends AppCompatActivity implements
        FragmentoPlanetas.OnFragmentInteractionListener,
        FragmentoNebulosas.OnFragmentInteractionListener,
        FragmentoGalaxias.OnFragmentInteractionListener,
        FragmentoConstelaciones.OnFragmentInteractionListener,
        FragmentoSupernovas.OnFragmentInteractionListener,
        FragmentoCometas.OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VIEWPAGER Y ADAPTERS DEL VIEWPAGER / CON SECCIONADAPTER DE 5 PAGINAS SWITCHEABLES

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.idDelViewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        //FLOATING ACTION BUTTON BACK, PARA VOLVER AL LAUNCHER


        FloatingActionButton back = findViewById(R.id.fab_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Launcher.class);
                startActivity(i);
            }


        });

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation1:
                FragmentoPlanetas planetfragment = new FragmentoPlanetas();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                return true;

            case R.id.navigation2:
                FragmentoNebulosas nebulafragment = new FragmentoNebulosas();
                android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.idDelViewPager, nebulafragment).commit();
                return true;

            case R.id.navigation3:
                FragmentoGalaxias galaxyfragment = new FragmentoGalaxias();
                android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.idDelViewPager, galaxyfragment).commit();
                return true;

            case R.id.navigation4:
                FragmentoConstelaciones constelacionesfragment = new FragmentoConstelaciones();
                android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.idDelViewPager, constelacionesfragment).commit();
                return true;

            case R.id.navigation5:
                FragmentoSupernovas accountFragment = new FragmentoSupernovas();
                android.support.v4.app.FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction4.replace(R.id.idDelViewPager, accountFragment).commit();

                return true;
        }
        return false;
    }
}



