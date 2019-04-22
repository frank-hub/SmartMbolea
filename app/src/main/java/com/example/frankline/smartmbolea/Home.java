package com.example.frankline.smartmbolea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Home extends AppCompatActivity {
    public CardView soilTest ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        soilTest = (CardView) findViewById(R.id.soil_test);

        soilTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent soil;
                soil = new Intent(v.getContext(),SoilTest.class);
                startActivity(soil);
            }
        });
    }
    public void fertProg(View v){
        Intent programs = new Intent(this,FertilizerPrograms.class);
        startActivity(programs);
    }
}
