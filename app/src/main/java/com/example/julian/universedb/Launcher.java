package com.example.julian.universedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


public class Launcher extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);


        LottieAnimationView button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        TextView poweredby = findViewById(R.id.powered);
        TextView dharma = findViewById(R.id.dharma);
        TextView universedb = findViewById(R.id.universedb);


        CardView cardviewtitle = findViewById(R.id.cardviewtitle);


        AnimationUtils.enterRight(universedb, 2000);
        AnimationUtils.enterLeft(cardviewtitle, 2100);
        AnimationUtils.rotateX(universedb, 2200);

        AnimationUtils.enterLeft(poweredby, 2200);
        AnimationUtils.enterLeft(dharma, 2000);
        AnimationUtils.rotateX(dharma, 2200);


    }
}

