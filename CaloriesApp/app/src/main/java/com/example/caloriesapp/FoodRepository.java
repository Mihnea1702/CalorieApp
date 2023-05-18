package com.example.caloriesapp;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class FoodRepository {
    private FoodDao foodDao;
    private LiveData<List<FoodEntity>> allFoods;

    public FoodRepository(Application application) {
        Database database = Database.getAppDatabase(application);
        foodDao = database.foodDao();
        allFoods = foodDao.getAllFoods();
    }

    public void insert(FoodEntity food) {
        new InsertNoteAsyncTask(foodDao).execute(food);
    }

    public LiveData<List<FoodEntity>> getAllFoods() {
        return allFoods;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<FoodEntity, Void, Void> {
        private FoodDao foodDao;

        private InsertNoteAsyncTask(FoodDao foodDao) {
            this.foodDao = foodDao;
        }

        @Override
        protected Void doInBackground(FoodEntity... foods) {
            foodDao.addFood(foods[0]);
            return null;
        }
    }

}
