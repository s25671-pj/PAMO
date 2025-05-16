package pamo.bmicalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;

/**
 * Fragment odpowiedzialny za kalkulację BMI na podstawie danych użytkownika
 * Umożliwia również wyświetlenie wykresu BMI po kliknięciu przycisku
 */
public class BMICalculatorFragment extends Fragment {

    private EditText enterWeight, enterHeight;
    private TextView result;

/**
 * Tworzy widok fragmentu, ładuje layout i ustawia logikę przycisków oraz pól tekstowych
 *
 * @param inflater obiekt odpowiedzialny za przekonwertownaie pliku XML na widok
 * @param container kontener (ViewGroup), do którego może zostać dołączony widok fragmentu
 * @param savedInstanceState stan zapisany przy poprzednim utworzeniu fragmentu
 * @return widok fragmentu do wyświetlenia na ekranie
 */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bmi_calculator, container, false);

        enterWeight = view.findViewById(R.id.enterWeight);
        enterHeight = view.findViewById(R.id.enterHeight);
        Button calculate = view.findViewById(R.id.calculate);
        Button showChartButton = view.findViewById(R.id.showChartButton);
        result = view.findViewById(R.id.result);
        ImageView bmiChartImage = view.findViewById(R.id.bmiChartImage);

        enterWeight.setOnClickListener(a -> enterWeight.setText(""));
        enterHeight.setOnClickListener(a -> enterHeight.setText(""));

        calculate.setOnClickListener(v -> calculateBMI());

        showChartButton.setOnClickListener(v -> {
            bmiChartImage.setVisibility(View.VISIBLE);
        });

        bmiChartImage.setOnClickListener(v -> {
            bmiChartImage.setVisibility(View.GONE);
        });

        return view;
    }

    /**
     * Pobiera dane z pól tekstowych i oblicza BMI.
     * Wynik zostaje wyświetlony w postaci tekstu.
     */
    private void calculateBMI() {
        String weightText = enterWeight.getText().toString();
        String heightText = enterHeight.getText().toString();

        if (!weightText.isEmpty() && !heightText.isEmpty()) {
            try {
                float weight = Float.parseFloat(weightText);
                float height = Float.parseFloat(heightText);

                String resultMsg = BMICalculator.calculate(weight, height);
                result.setText(resultMsg);
            } catch (NumberFormatException e) {
                result.setText("Podaj poprawne wartości liczbowe!");
            }
        } else {
            result.setText("Uzupełnij wszystkie pola!");
        }
    }
}
