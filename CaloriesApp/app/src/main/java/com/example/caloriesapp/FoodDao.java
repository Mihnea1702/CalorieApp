package com.example.caloriesapp;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface FoodDao {
    @Insert
    void addFood(FoodEntity foodEntity);

    @Query("SELECT * from food where foodName = (:foodName)")
    FoodEntity getFood(String foodName);

    @Query("SELECT * FROM food")
    LiveData<List<FoodEntity>> getAllFoods();
}
