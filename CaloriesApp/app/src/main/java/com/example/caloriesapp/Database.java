package com.example.caloriesapp;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities =  {FoodEntity.class, UserEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static final String dbName = "CaloriesApp";
    private static Database database;

    public static synchronized Database getAppDatabase(Context context){

        if(database == null){
            database = Room.databaseBuilder(context, Database.class, dbName).fallbackToDestructiveMigration().build();
        }
        return database;
    }

    public abstract UserDao userDao();
    public abstract FoodDao foodDao();

}