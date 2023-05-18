package com.example.caloriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {

    TextView tName,calories;
    Button allFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        tName = findViewById(R.id.name);
        String name = getIntent().getStringExtra("name");
        int index=name.indexOf("-");
        tName.setText(name.substring(0,index));

        allFood=findViewById(R.id.allFood);
        allFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, AllFoods.class));
            }
        });

        calories=findViewById(R.id.calories);
        calories.setText(name.substring(index+1,name.length()));
    }
}