package pamo.bmicalc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.List;

/**
 * Fragment wyświetlający listę przepisów dopasowanych do limitu kalorii przekazanaych w SharedPreferences.
 *
 * Pobiera wartość limitu kalorii z SharedPreferences, a następnie filtruje listę wszystkich przepisów, wybierając te mieszczące się
 * w limicie kalorycznym i wyświetla je
 */
public class RecipeFragment extends Fragment {

    /**
     * Tworzy i zwraca widok fragmentu, ustawia jego układ, pobiera limit kalorii z SharedPreferences,
     * wybiera odpowiednie przepisy oraz je wyświetla
     * Jeśli nie znajdzie żadnych przepisów mieszczących się w limicie, to wyświetla komunikat
     *
     * @param inflater obiekt odpowiedzialny za przekonwertownaie pliku XML na widok
     * @param container kontener (ViewGroup), do którego może zostać dołączony widok fragmentu
     * @param savedInstanceState stan zapisany przy poprzednim utworzeniu fragmentu
     * @return gotowy widok fragmentu (przepisy)
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);
        TextView textRecipes = view.findViewById(R.id.textRecipes);

        SharedPreferences prefs = requireContext().getSharedPreferences("CaloriesPrefs", Context.MODE_PRIVATE);
        int calorieLimit = prefs.getInt("calories", 0);

        List<Recipe> allRecipes = Recipe.getAllRecipes();
        List<Recipe> selected = RecipeSelector.selectRecipes(allRecipes, calorieLimit);

        StringBuilder displayText = new StringBuilder();
        displayText.append("Zalecane przepisy do ").append(calorieLimit).append(" kcal:\n\n");
        for (Recipe r : selected) {
            displayText.append("• ").append(r.name).append(" - ").append(r.calories).append(" kcal\n");
        }

        if (selected.isEmpty()) {
            displayText.append("Brak przepisów mieszczących się w limicie.");
        }

        textRecipes.setText(displayText.toString());
        return view;
    }
}
