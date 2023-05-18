package com.example.caloriesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder> {

    private List<FoodEntity> foods=new ArrayList<>();




    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_item,parent,false);
        return new FoodHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
        FoodEntity currentFood=foods.get(position);
        holder.name.setText(currentFood.foodName);
        holder.calories.setText(currentFood.calories);
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public void setFoods(List<FoodEntity> foods){
        this.foods=foods;
        notifyDataSetChanged();
    }

    public class FoodHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView calories;

        public FoodHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            calories=itemView.findViewById(R.id.calories);
        }
    }
}