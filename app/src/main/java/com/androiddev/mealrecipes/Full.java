package com.androiddev.mealrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Full extends AppCompatActivity {
    ImageView imageView;
    TextView ingredients,method,prep,cook,kcal,serves,title;

    Intent intent = getIntent();
    int position = Integer.parseInt(intent.getExtras().getString("position"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);
        getSupportActionBar().setTitle("Detailed View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        imageView = (ImageView) findViewById(R.id.MainPhoto);
        ingredients = (TextView) findViewById(R.id.ingredients);
        method = (TextView) findViewById(R.id.method);
        prep= (TextView) findViewById(R.id.prep);
        cook= (TextView) findViewById(R.id.cook);
        kcal= (TextView) findViewById(R.id.kcal);
        serves= (TextView) findViewById(R.id.serves);
        title= (TextView) findViewById(R.id.MainTitle);

        imageView.setImageResource(position);
        ingredients.setText(RecipesDB.getRecipeArrayList().get(position).getIngredients());
        method.setText(RecipesDB.getRecipeArrayList().get(position).getMethod());
        prep.setText(RecipesDB.getRecipeArrayList().get(position).getTimePrep());
        cook.setText(RecipesDB.getRecipeArrayList().get(position).getTimeCook());
        kcal.setText(RecipesDB.getRecipeArrayList().get(position).getKcal());
        serves.setText(RecipesDB.getRecipeArrayList().get(position).getServes());
        title.setText(RecipesDB.getRecipeArrayList().get(position).getTitle());





    }
}