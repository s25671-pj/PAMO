package pamo.bmicalc;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Główna aktywność aplikacji, która zarządza nawigacją dolnym paskiem (BottomNavigationView)
 * i wyświetla odpowiednie fragmenty w zależności od wybranego elementu menu.
 *
 * Po uruchomieniu aktywności domyślnie ładowany jest fragment kalkulatora BMI (wcześniej ładuje się SplashActivity
 * jako "main screen").
 */
public class HomeActivity extends AppCompatActivity {

    /**
     * Metoda wywoływana przy tworzeniu aktywności.
     *
     * Inicjalizuje widok, ustawia domyślny fragment (BMICalculatorFragment) oraz
     * odpowiada za nasłuchiwanie wyboru elementów w dolnym pasku nawigacyjnym
     * (BottomNavigationView). W zależności od wybranego elementu, wyświetla:
     * kalkulator BMI, kalkulator kalorii, przepisy lub listę zakupów
     *
     * @param savedInstanceState zapisany stan aktywności
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new BMICalculatorFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();

            if (id == R.id.nav_bmi) {
                selectedFragment = new BMICalculatorFragment();
            } else if (id == R.id.nav_calories) {
                selectedFragment = new CaloriesCalculatorFragment();
            } else if (id == R.id.nav_recipes) {
                selectedFragment = new RecipeFragment();
            } else if (id == R.id.nav_shopping) {
                selectedFragment = new ShoppingListFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment).commit();
            }

            return true;
        });
    }
}