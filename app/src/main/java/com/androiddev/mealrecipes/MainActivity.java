package com.androiddev.mealrecipes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Recipe> recipes ;
    RecyclerView recyclerView;
    RecipesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Meal Recipes");

        createArrayList();
        buildAdapter();
    }

    private void buildAdapter() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new RecipesAdapter(RecipesDB.getRecipeArrayList());
        adapter.setRecipeClickListener(new RecipeClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this,Full.class);
                intent.putExtra("position",position);
                Log.i("MyTag",String.valueOf(position));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.more:
                Intent intent = new Intent(this, favourite.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }


    private void createArrayList() {
        RecipesDB.addToRecipeList(new Recipe(R.drawable.harissa,"Harissa","Good Meal",false,"15","1","450","5","180g pack grilled artichokes\n" +
                "1½ tbsp olive oil\n" +
                "1 tsp dried oregano\n" +
                "2 tsp cumin seeds\n" +
                "8 chicken drumsticks\n" +
                "1 butternut squash, cut into chunks (leave the skin on – it adds flavour)\n" +
                "150g mixed olives of your choice, roughly chopped\n" +
                "large handful rocket"));

        RecipesDB.addToRecipeList(new Recipe(R.drawable.harissa,"marissa","bad Meal",false,"35","10","5650","3","180g pack grilled artichokes\n" +
                "1½ tbsp olive oil\n" +
                "1 tsp dried oregano\n" +
                "2 tsp cumin seeds\n" +
                "8 chicken drumsticks\n" +
                "1 butternut squash, cut into chunks (leave the skin on – it adds flavour)\n" +
                "150g mixed olives of your choice, roughly chopped\n" +
                "large handful rocket"));
    }
}