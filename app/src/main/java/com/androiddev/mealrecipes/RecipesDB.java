package com.androiddev.mealrecipes;

import java.util.ArrayList;

public class RecipesDB {

    private static ArrayList<Recipe> recipeArrayList = new ArrayList<Recipe>();

    public static ArrayList<Recipe> getRecipeArrayList() {return recipeArrayList;};
    public static void addToRecipeList(Recipe recipe ){ recipeArrayList.add(recipe);}

}


