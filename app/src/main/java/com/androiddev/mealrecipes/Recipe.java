package com.androiddev.mealrecipes;

public class Recipe {
    private int imageResource;
    private String title;
    private String method;
    private boolean fav ;
    private String timePrep;
    private String timeCook;
    private String kcal;
    private String serves;
    private String ingredients;


    public String getIngredients() {
        return ingredients;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }


    public boolean isFav() {
        return fav;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getMethod() {
        return method;
    }

    public String getTimePrep() {
        return timePrep;
    }

    public String getTimeCook() {
        return timeCook;
    }

    public String getKcal() {
        return kcal;
    }

    public String getServes() {
        return serves;
    }

    public Recipe(int imageResource, String title, String method,boolean fav, String timePrep, String timeCook, String kcal, String serves,String ingredients) {
        this.imageResource = imageResource;
        this.title = title;
        this.method = method;
        this.fav = false;
        this.ingredients = ingredients;
        this.timePrep = timePrep;
        this.timeCook = timeCook;
        this.kcal = kcal;
        this.serves = serves;
    }
}
