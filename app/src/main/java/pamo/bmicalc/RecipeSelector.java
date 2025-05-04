package pamo.bmicalc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecipeSelector {

    public static List<Recipe> selectRecipes(List<Recipe> recipes, int calorieLimit) {
        List<Recipe> shuffled = new ArrayList<>(recipes);
        Collections.shuffle(shuffled);

        List<Recipe> selected = new ArrayList<>();
        int remainingCalories = calorieLimit;

        for (Recipe recipe : shuffled) {
            if (recipe.calories <= remainingCalories) {
                selected.add(recipe);
                remainingCalories -= recipe.calories;
            }
        }

        return selected;
    }
}
