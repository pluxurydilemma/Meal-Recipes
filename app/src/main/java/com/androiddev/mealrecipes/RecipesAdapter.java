package com.androiddev.mealrecipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeHolder> {

    public RecipesAdapter(ArrayList<Recipe> recipes) {
        recipeArrayList = recipes;
    }

    private ArrayList<Recipe> recipeArrayList;

//    init listener
    private RecipeClickListener listener ;

//    set listener
    public void setRecipeClickListener(RecipeClickListener listener){
        this.listener=listener;
    }






    public static class RecipeHolder extends RecyclerView.ViewHolder {
        ImageView imageView,bin;
        TextView header, description, time;


        public RecipeHolder(@NonNull View itemView,RecipeClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.photo);
            header = itemView.findViewById(R.id.Title);
            description = itemView.findViewById(R.id.description);
            time = itemView.findViewById(R.id.timeOfCooking);
            bin = itemView.findViewById(R.id.imageView6);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                int position = getAdapterPosition();
                listener.onClick(position);
                }
            });

            bin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bin.setImageResource(R.drawable.ic_baseline_delete_24);
                    RecipesDB.getRecipeArrayList().get(getAdapterPosition()).setFav(true);
                }
            });

        }
    }


    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_card, parent, false);
        return new RecipeHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeHolder holder, int position) {
        Recipe currentItem = recipeArrayList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.header.setText(currentItem.getTitle());
        holder.description.setText(currentItem.getMethod());
        holder.time.setText(currentItem.getTimeCook());

    }

    @Override
    public int getItemCount() {
        return recipeArrayList.size();
    }
}
