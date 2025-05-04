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

public class RecipeFragment extends Fragment {

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
