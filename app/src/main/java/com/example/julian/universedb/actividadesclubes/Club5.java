package com.example.julian.universedb.actividadesclubes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.julian.universedb.AnimationUtils;
import com.example.julian.universedb.R;


public class Club5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club5);

        ImageView psg = findViewById(R.id.psg);
        AnimationUtils.enterTop(psg, 1000);

    }
}
