package com.example.caloriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    TextView tName,food;
    Button allFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        tName = findViewById(R.id.name);
        String name = getIntent().getStringExtra("name");
        tName.setText(name);

        food= findViewById(R.id.food);
        allFood=findViewById(R.id.allFood);

    }
}