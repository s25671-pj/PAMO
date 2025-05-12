package pamo.bmicalc;

import java.util.Arrays;
import java.util.List;

public class Recipe {
    public final String name;
    public final String description;
    public final int calories;
    public final String dietType;

    public Recipe(String name, String description, int calories, String dietType) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.dietType = dietType;
    }

    public static List<Recipe> getAllRecipes() {
        return Arrays.asList(
                new Recipe("Kurczak z ryżem", "Gotowany kurczak z warzywami i ryżem", 600, "Klasyczna"),
                new Recipe("Wege sałatka z kasztanami", "Kasztany, ciecierzyca, warzywa, oliwa", 450, "Wegetariańska"),
                new Recipe("Omlet białkowy", "Omlet z 3 jaj, pomidorami i szpinakiem", 350, "Klasyczna"),
                new Recipe("Tajskie curry z tofu", "Tofu w mleczku kokosowym z warzywami", 550, "Wegetariańska")
        );
    }
}
