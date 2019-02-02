package com.example.julian.universedb;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
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
        FragmentoCometas.OnFragmentInteractionListener {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VIEWPAGER Y ADAPTERS DEL VIEWPAGER / CON SECCIONADAPTER DE 5 PAGINAS SWITCHEABLES

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.idDelViewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        //Menu De Navegacion Bottom Bar ( Indica que empieza seleccionado el item °1)
        BottomNavigationView BottomNavigationView = findViewById(R.id.navigationView);
        BottomNavigationView.setSelectedItemId(R.id.navigation1);

        //ACCIONES DE LOS 5 BOTONES DE LA NAVIGATION BOTTOM BAR
        BottomNavigationItemView item1 = findViewById(R.id.navigation1);
        BottomNavigationItemView item2 = findViewById(R.id.navigation2);
        BottomNavigationItemView item3 = findViewById(R.id.navigation3);
        BottomNavigationItemView item4 = findViewById(R.id.navigation4);
        BottomNavigationItemView item5 = findViewById(R.id.navigation5);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FragmentoPlanetas.class);
                startActivity(i);

            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FragmentoNebulosas.class);
                startActivity(i);

            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FragmentoGalaxias.class);
                startActivity(i);

            }
        });

        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FragmentoConstelaciones.class);
                startActivity(i);

            }
        });

        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FragmentoSupernovas.class);
                startActivity(i);

            }
        });



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
