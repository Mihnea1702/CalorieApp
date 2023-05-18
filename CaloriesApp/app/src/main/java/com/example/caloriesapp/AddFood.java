package com.example.caloriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFood extends AppCompatActivity {
    EditText foodName, foodCalorie;
    Button addFoodBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        foodName = findViewById(R.id.foodName);
        foodCalorie = findViewById(R.id.foodCalorie);
        addFoodBtn = findViewById(R.id.addFoodBtn);

        addFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodNameS = foodName.getText().toString();
                String foodCalorieS = foodCalorie.getText().toString();
                if (foodNameS.isEmpty() || foodCalorieS.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    FoodEntity foodEntity = new FoodEntity();
                    foodEntity.setFoodName(foodNameS);
                    foodEntity.setCalories(foodCalorieS);
                    Database database = Database.getAppDatabase(getApplicationContext());
                    FoodDao foodDao = database.foodDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            foodDao.addFood(foodEntity);
                            startActivity(new Intent(AddFood.this, AllFoods.class));
                        }
                    }).start();
                }
            }

        });
    }
}