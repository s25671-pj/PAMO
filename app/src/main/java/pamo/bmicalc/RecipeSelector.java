package pamo.bmicalc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Odpowiada za dobieranie przepisów mieszczącch się w limicie kalorycznym
 */
public class RecipeSelector {

    /**
     * Dobiera tak przepisy aby nie przekroczył limitu, uprzednio przetasowując listę
     * aby każde wywołanie nie wiązało się z pobieram po kolei tych samych przepisów
     *
     * @param recipes lista dostępnych przepisów do wyboru
     * @param calorieLimit maksymalna dopuszczalna suma kalorii dla wybranych przepisów
     * @return lista przepisów wybranych do limitu kalorycznego
     */
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
