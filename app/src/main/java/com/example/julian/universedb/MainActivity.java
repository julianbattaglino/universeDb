package com.example.julian.universedb;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.julian.universedb.ViewPager.FragmentoCometas;
import com.example.julian.universedb.ViewPager.FragmentoConstelaciones;
import com.example.julian.universedb.ViewPager.FragmentoGalaxias;
import com.example.julian.universedb.ViewPager.FragmentoNebulosas;
import com.example.julian.universedb.ViewPager.FragmentoPlanetas;
import com.example.julian.universedb.ViewPager.FragmentoSupernovas;
import com.example.julian.universedb.ViewPager.SectionsPagerAdapter;


public class MainActivity extends AppCompatActivity implements
        FragmentoPlanetas.OnFragmentInteractionListener,
        FragmentoNebulosas.OnFragmentInteractionListener,
        FragmentoGalaxias.OnFragmentInteractionListener,
        FragmentoConstelaciones.OnFragmentInteractionListener,
        FragmentoSupernovas.OnFragmentInteractionListener,
        FragmentoCometas.OnFragmentInteractionListener {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VIEWPAGER Y ADAPTERS DEL VIEWPAGER / CON SECYIONADAPTER DE 5 PAGINAS SWITCHEABLES

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.idDelViewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        //AGREGAR ACCIONES A LOS 5 BOTONES DE LA NAVIGATION BOTTOM BAR
        BottomNavigationView BottomNavigationView = findViewById(R.id.navigationView);

        BottomNavigationView.setSelectedItemId(R.id.navigation1);


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
}
