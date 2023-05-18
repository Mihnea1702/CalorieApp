package com.example.caloriesapp;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class FoodViewModel extends AndroidViewModel {
    private FoodRepository repository;
    private LiveData<List<FoodEntity>> allFoods;

    public FoodViewModel(@NonNull Application application) {
        super(application);
        repository = new FoodRepository(application);
        allFoods = repository.getAllFoods();
    }

    public void insert(FoodEntity food) {
        repository.insert(food);
    }

    public LiveData<List<FoodEntity>> getAllFoods() {
        return allFoods;
    }
}
