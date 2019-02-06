package com.example.julian.universedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class Launcher extends AppCompatActivity {

    boolean isActividadSelected = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);


        TextView poweredby = findViewById(R.id.powered);
        TextView dharma = findViewById(R.id.dharma);
        TextView universedb = findViewById(R.id.universedb);


        ImageView moon = findViewById(R.id.moon);
        CardView cardviewtitle = findViewById(R.id.cardviewtitle);
        CardView cardviewspinner = findViewById(R.id.cardviewspinner);
        Spinner spinner = findViewById(R.id.spinner);



        AnimationUtils.enterLeft(cardviewspinner, 1500);

        AnimationUtils.enterRight(universedb, 2000);
        AnimationUtils.enterLeft(cardviewtitle, 2100);
        AnimationUtils.rotateX(universedb, 2200);

        AnimationUtils.enterLeft(poweredby, 2200);
        AnimationUtils.enterLeft(dharma, 2000);
        AnimationUtils.rotateX(dharma, 2200);

        RotateAnimation rotate = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotate.setDuration(4000);
        rotate.setRepeatCount(Animation.INFINITE);
        moon.startAnimation(rotate);


        spinner.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.spinner_divisiones)));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                if (isActividadSelected) {
                    openMainActivity(pos);
                }
                isActividadSelected = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });
    }

    private void openMainActivity(int pos) {
        //Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(pos), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Launcher.this, MainActivity.class);
        i.putExtra("", pos);
        startActivity(i);
    }
}

