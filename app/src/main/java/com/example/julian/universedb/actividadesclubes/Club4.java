package com.example.julian.universedb.actividadesclubes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.julian.universedb.AnimationUtils;
import com.example.julian.universedb.R;


public class Club4 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club4);

        ImageView br = findViewById(R.id.br);
        AnimationUtils.enterTop(br, 1000);
    }
}
